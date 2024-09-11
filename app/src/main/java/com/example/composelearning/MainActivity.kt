package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Hello world")
        }
    }
}

@Preview(
    showBackground = true,
    name = "hello message",
    showSystemUi = true,
    widthDp = 200,
    heightDp = 200
)
@Composable
fun SayCheezy(name: String = "Cheezy code") {
//    Text(
//        text = "Hello $name", fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
//        fontWeight = FontWeight.Bold,
//        color = Color.Blue,
//        fontSize = 40.sp,
//        textAlign = TextAlign.Right
//    )
//    Image(painter = painterResource(id = androidx.core.R.drawable.ic_call_answer), contentDescription = "Dummy Image", colorFilter = ColorFilter.tint(
//        Color.Blue
//    ), contentScale = ContentScale.Fit )

    Button(onClick = { }) {
        
    }
}

