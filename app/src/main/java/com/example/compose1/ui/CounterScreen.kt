package com.example.compose1.ui

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen() {
    val context = LocalContext.current
    var count by remember { mutableIntStateOf(0) }
    val textColor by animateColorAsState(
        targetValue = when {
            count >= 25 -> Color.Red
            count >= 20 -> Color.Cyan
            count >= 15 -> Color.Blue
            count >= 5 -> Color.Green
            else -> Color.Black
        },
        animationSpec = tween(durationMillis = 500), label = ""
    )
    val textSize = when{
        count >= 25 -> 30.sp
        count >= 20 -> 25.sp
        count >= 15 -> 20.sp
        count >= 5 -> 15.sp
        else -> 10.sp
    }
    if (count >= 25) {
        Toast.makeText(context, "You have won!", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You have clicked $count times",
            style = TextStyle(color = textColor, fontSize = textSize, fontWeight = FontWeight.Bold),
        )
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = {
            count++
        }, enabled = count <= 24) {
            Text(text = "Click")
        }
        Spacer(modifier = Modifier.height(64.dp))
        Button(onClick = { count = 0 }) {
            Text(text = "Reset")

        }
    }

}