package com.example.godaddyinterview.interview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class GridProps(
    val products: List<ProductProps>
)

@Composable
fun GridComposable(props: GridProps) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        content = {
            items(props.products.size) { index ->
                ItemComposable(itemProps = props.products[index])
            }
        },
        modifier = Modifier.padding(2.dp).fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    )
}


