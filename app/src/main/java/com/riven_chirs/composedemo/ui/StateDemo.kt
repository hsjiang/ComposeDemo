package com.riven_chirs.composedemo.ui

import android.util.Log
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import com.riven_chirs.composedemo.ui.theme.purple200
import com.riven_chirs.composedemo.ui.theme.teal200


@Composable
fun IntState(name: String) {
    val counterState = state { 0 }

    Column {
        Text(text = "Hello $name!")
        TextButton(onClick = { counterState.value++ }) {
            Text(text = "Hello $name!", style = MaterialTheme.typography.h3)
        }

        Counter(counterState.value)
    }
}

@Composable
fun Counter(count: Int) {
    Button(
        onClick = { },
        backgroundColor = if (count < 5) purple200 else teal200
    ) {
        Log.d("click", "$count")
        Text("I've been clicked $count times")
    }
}
