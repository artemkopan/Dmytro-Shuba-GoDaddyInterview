package com.example.godaddyinterview.interview

import androidx.compose.ui.graphics.Color
import java.util.UUID

/*
Product Card Specs
Color = Default should be #FF09757A
Name = Color #111111
Short Code = Default to first 5 letters of name if null. Color #FFFFFF
Inventory = Hidden if null. Text color = #5E5E5E
Amount = Hidden if null. Text Color = #5E5E5E

Empty Card Background = 0xFF181818
4 Columns vs 6 Rows = 24 Cards
There should be at least 24 Cards on the screen.
Example: If there is just 5 Products,then we have 5 Product Cards and 19 Empty Cards

Buttons:
Cancel = #111111
CASH = #0B3354
Charge = #1976D2
 */

data class Product(
    val productId: String,
    val name: String,
    val color: String? = null,
    val shortCode: String? = null,
    val amount: Long? = null,
    val inventory: Int? = null,
) {
    companion object
}

fun Product.Companion.get(): List<Product> {
    return listOf(
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FFAE1302",
            shortCode = "APPLE",
            name = "Apple Pie",
            amount = 750,
            inventory = 10,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "ALMON",
            name = "Almond Tart",
            amount = 350,
            inventory = 4,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FF145FA9",
            shortCode = "BBQCH",
            name = "BBQ Chicken",
            amount = 1450,
            inventory = 4,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "BROWN",
            name = "Brownies",
            amount = 100,
            inventory = 10,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "CAPPU",
            name = "Cappuccino",
            amount = 300,
            inventory = 7,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "CAPRE",
            name = "Caprese",
            amount = 200,
            inventory = 4,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FFB4006C",
            shortCode = "COOKI",
            name = "Chocolate Chip Cookies",
            amount = 78,
            inventory = 99,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "COFFE",
            name = "Coffe",
            amount = 150,
            inventory = 22,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "DAILY",
            name = "Daily Special",
            amount = 20050,
            inventory = 2,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "GRILL",
            name = "Grilled Cheese",
            amount = 1600,
            inventory = 2,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "HAMCH",
            name = "Ham and Cheese",
            amount = 1100,
            inventory = 6,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "ITALI",
            name = "Italian Coffee",
            amount = 350,
            inventory = 12,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FF9D470A",
            shortCode = "ORANG",
            name = "Orange Juice",
            amount = 450,
            inventory = 33,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FFEAB303",
            shortCode = "LEMON",
            name = "Lemon Juice",
            amount = 250,
            inventory = 10,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FF145FA9",
            shortCode = "MACCH",
            name = "Macchiato",
            amount = 700,
            inventory = 4,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "CAKE",
            name = "Sweet Cake",
            amount = 1230,
            inventory = 4,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "OATME",
            name = "Oatmeal Cookies",
            amount = 99,
            inventory = 2,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "PEANU",
            name = "Peanut Butter Cookies",
            amount = 300,
            inventory = 6,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FFC4580C",
            shortCode = "PUMPK",
            name = "Pumpkin Pie",
            amount = 1150,
            inventory = 3,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            shortCode = "SODA",
            name = "Soda",
            amount = 422,
            inventory = 11,
        ),
        Product(
            productId = UUID.randomUUID().toString(),
            color = "#FF9D470A",
            shortCode = "TUBAI",
            name = "Tubaina",
            amount = 799,
            inventory = 12,
        ),
    )
}

fun Color.Companion.fromHex(hex: String?, defaultColor: Color): Color {
    if (hex.isNullOrBlank()) return defaultColor

    try {
        return Color(android.graphics.Color.parseColor(hex))
    } catch (e: Exception) {
        // ignore
    }

    return defaultColor
}