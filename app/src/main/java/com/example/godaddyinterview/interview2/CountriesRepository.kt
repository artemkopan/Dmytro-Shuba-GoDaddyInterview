package com.example.godaddyinterview.interview2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CountriesRepository(
    private val networkComponent: NetworkComponent,
    private val databaseComponent: DatabaseComponent,
    private val coroutineScope: CoroutineScope // Dispatchers.IO
) {

    val countriesListFlow = Flow<Result<List<Country>>>

    fun getCountriesList() {
        coroutineScope.launch {
            val localCountriesList = async {
                queryCountriesList()
            }
            val remoteCountriesList = async {
                fetchCountriesList()
            }

            val countriesList = localCountriesList.await()
            countriesListFlow.emit(countriesList.transformToCountry())
            val remoteCountryListResponse = remoteCountriesList.await()
            when {
                remoteCountryListResponse.isSuccessful() -> {
                    countriesListFlow.emit(remoteCountryListResponse.data.transformToCountry())
                    val localCountryList = remoteCountryListResponse.data.transformToCountry().transformToDatabaseModel()
                    updateCountriesList(localCountryList)
                }
            }
        }
    }

    private suspend fun fetchCountriesList() {
        networkComponent.countryApi.fetchCountryList()
    }

    private suspend fun queryCountriesList() {
        databaseComponent.queryCountryList()
    }

    private suspend fun updateCountriesList(countryList: List<Country>) {
        databaseComponent.updateCountriesList(countryList)
    }
}

