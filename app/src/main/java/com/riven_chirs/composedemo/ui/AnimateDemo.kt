package com.riven_chirs.composedemo.ui

import androidx.animation.FloatToVectorConverter
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.DpToVectorConverter
import androidx.ui.animation.animatedValue
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.size
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.riven_chirs.composedemo.R

@Composable
fun Animate1() {
    val selected = state { false }
    val radius =
        animatedValue(initVal = if (selected.value) 50.dp else 8.dp, converter = DpToVectorConverter)
    val alpha =
        animatedValue(initVal = if (selected.value) 0.5f else 1f, converter = FloatToVectorConverter)

    Surface(
        shape = RoundedCornerShape(
            topLeft = radius.value,
            topRight = radius.value,
            bottomRight = radius.value,
            bottomLeft = radius.value
        )
    ) {
        Image(
            asset = imageResource(R.drawable.four),
            modifier = Modifier.size(100.dp, 100.dp)
                .clickable(onClick = {
                    selected.value = !selected.value
                }),
            contentScale = ContentScale.Crop,
            alpha = alpha.value
        )
    }
}