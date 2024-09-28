package com.example.composelearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularImage()
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

//    Button(
//        onClick = { },
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.White,
//            containerColor = Color.Black
//        ),
//        enabled = true,
//        shape = RectangleShape
//    ) {
//        Text(text = "Hello Click")
//        Image(
//            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
//            contentDescription = "Dummy Image",
//            colorFilter = ColorFilter.tint(
//                Color.White
//            )
//        )
//    }
//    TextField(value = "Hello world", onValueChange = {}, label = { Text(text = "tryword") })

    //layout equivalent to linear layout orientation - vertical
//    Column(verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.End) {
//        Text(text = "A", fontSize = 24.sp)
//        Text(text = "B", fontSize = 24.sp)
//    }

    //layout equivalent to linear layout orientation - horizontal

//    Row(horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically
//        ) {
//        Text(text = "A", fontSize = 24.sp)
//        Text(text = "B", fontSize = 24.sp)
//    }

    // used when we want view over one another.
//    Box (contentAlignment = Alignment.CenterStart){
//        Image(painter = painterResource(id = androidx.core.R.drawable.ic_call_answer), contentDescription = "")
//        Image(painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video), contentDescription = "")
//
//    }

    // a list type functionality
//Column {
//    ListViewItem(image = R.drawable.baseline_person, name ="John Doe" , occupation = "Software Engineer")
//    ListViewItem(image = R.drawable.baseline_person, name ="John Doe" , occupation = "Software Engineer")
//    ListViewItem(image = R.drawable.baseline_person, name ="John Doe" , occupation = "Software Engineer")
//    ListViewItem(image = R.drawable.baseline_person, name ="John Doe" , occupation = "Software Engineer")
//
//}


    // Modifier used to modify the general properties in a composable.
    // Sequence of properties in modifier matters.
    Text(
        modifier = Modifier
            .background(Color.Blue)
            .clickable { }
            .size(200.dp)
            .padding(10.dp)
            .border(4.dp, Color.Red)
            .clip(
                CircleShape
            )
            .background(Color.Yellow), text = "Hello"
    )

}


//list item view
@Composable
fun ListViewItem(image: Int, name: String, occupation: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = image), contentDescription = "", Modifier.size(40.dp))
        Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.Center) {
            Text(text = name, fontSize = 24.sp)
            Text(text = occupation, fontSize = 12.sp, fontWeight = FontWeight.Thin)
        }
    }
}

@Composable
fun TextInput() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value, onValueChange = {
        state.value = it
        Log.d("TextField logs", it)
    }, label = { Text(text = "Try word") })
}

@Composable
fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.linkedin),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(
                CircleShape
            )
            .border(2.dp, Color.Gray, CircleShape)
    )
}

