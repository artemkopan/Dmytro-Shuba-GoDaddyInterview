package com.example.godaddyinterview.interview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* TODO
1. Convert Long to Double number
2. Specify card measurements

todo
1. remember (key) - have a look
2. @Stable or @Immutable
3. ImmutableList
4. ImmutableCollections

Width. 142.dp
Height = 161
 */

@Immutable
data class ProductProps(
    val topColor: Color,
    val shortCode: String,
    val name: String,
    val amount: String
)

@Composable
fun ItemComposable(itemProps: ProductProps) {
    val code = itemProps.shortCode
    val name = itemProps.name
    val amount = itemProps.amount

    val currency = PRODUCT_CURRENCY
    val color = itemProps.topColor

    Column (
        modifier = Modifier
            .width(142.dp)
            .height(100.dp)
            .padding(1.dp)
            .background(Color.White)
            .border(
                width = 0.dp,
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            )

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = code,
                color = if (color == Color.White) Color.Black else Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(2.dp)
                .defaultMinSize(minHeight = 56.dp)
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )

            val amountValue = currency + amount
            Text(
                text = amountValue,
                color = Color.DarkGray,
                fontSize = 10.sp
            )
        }
    }
}

const val PRODUCT_CURRENCY = "$"
