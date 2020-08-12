package com.riven_chirs.composedemo.ui

import android.util.Log
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.drawShadow
import androidx.ui.core.gesture.longPressGestureFilter
import androidx.ui.core.gesture.tapGestureFilter
import androidx.ui.foundation.Image
import androidx.ui.foundation.drawBorder
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.graphics.Shape
import androidx.ui.layout.padding
import androidx.ui.layout.size
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.riven_chirs.composedemo.R


@Composable
fun LoadImage(){
    val (shape, setShape) = state<Shape> { CircleShape }
    Image(
        imageResource(id = R.drawable.four),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(200.dp, 200.dp)
            .padding(40.dp)
            .drawShadow(1.dp, shape = shape)
            .drawBorder(6.dp, MaterialTheme.colors.primary, shape = shape)
            .longPressGestureFilter {
                Log.d("press", "longPressGestureFilter: $it")
                setShape(CircleShape)
            }
            .tapGestureFilter {
                Log.d("press", "onClick")
                setShape(
                    if (shape == CircleShape)
                        CutCornerShape(topLeft = 32.dp, bottomRight = 32.dp)
                    else
                        CircleShape
                )
            }
    )
}