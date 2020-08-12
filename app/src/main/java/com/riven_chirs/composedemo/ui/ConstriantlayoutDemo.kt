package com.riven_chirs.composedemo.ui

import android.content.Context
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.ConstraintLayout
import androidx.ui.layout.ConstraintSet
import androidx.ui.layout.ConstraintSet2
import androidx.ui.layout.height
import androidx.ui.unit.dp


@Composable
fun Constriantlayout1() {
    ConstraintLayout(
        constraintSet = ConstraintSet2 {

        },
        modifier = Modifier.height(200.dp)
    ) {

    }
}