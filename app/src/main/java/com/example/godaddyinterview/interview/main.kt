package com.example.godaddyinterview.interview

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MainGrid() {
    val products = Product.get()
    val productPropsList = products.map { transformProductsToProps(it) }
    val gridProps = GridProps(productPropsList)
    GridComposable(gridProps)
}

fun transformProductsToProps(product: Product): ProductProps {
    return ProductProps(
        topColor = Color.fromHex(product.color, Color.White),
        shortCode = product.shortCode ?: "",
        name = product.name,
        amount = convertLongToDouble(product.amount ?: 0)
    )
}

fun convertLongToDouble(value: Long): String {
    val original = value.toString()
    return when {
        original.length >= 3 -> {
            val left = original.substring(0, original.length - 2)
            val right = "." + original.substring(original.length - 2, original.length)
            left + right
        }
        else -> {
            "0.$original"
        }
    }
}
