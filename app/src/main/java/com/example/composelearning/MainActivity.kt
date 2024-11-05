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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screen = Screen()

        setContent {
//            screen.PreviewItem()
//            Recomposable()
//            Counter()
//            LaunchEffectComposable()
//            CoroutineScopeComposable()
            App()
        }
    }
}

fun a() {
    Log.d("Logs", "I am A from App")
}

fun b() {
    Log.d("Logs", "I am B from App")
}

@Composable
fun App() {
    var state = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)
}


@Composable
fun LandingScreen(value: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(value)
    LaunchedEffect(true) {
        delay(5000)
        currentOnTimeout()
    }
}

//@Composable
//fun CoroutineScopeComposable(){
//    val counter = remember {
//        mutableStateOf(0)
//    }
//    var scope = rememberCoroutineScope()
//
//    var text = "Counter is running ${counter.value}"
//    if (counter.value==10){
//        text = "Counter stopped"
//    }
//    Column {
//        Text(text = text)
//        Button(onClick = {
//            scope.launch {
//                Log.d("LaunchedEffectComposable", "Started...")
//                try {
//                    for (i in 1..10){
//                        counter.value++
//                        delay(1000)
//                    }
//                }catch (e:Exception){
//                    Log.d("LaunchedEffectComposable", "Exception - ${e.message.toString()}")
//                }
//            }
//        }) {
//            Text(text = "Start")
//        }
//    }
//}

@Composable
fun LaunchEffectComposable() {
    val counter = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = Unit) {
        Log.d("LaunchedEffectComposable", "Started...")
        try {
            for (i in 1..10) {
                counter.value++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("LaunchedEffectComposable", "Exception - ${e.message.toString()}")
        }
    }

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }
    Text(text = text)
}

//@Composable
//fun Counter() {
//    var count = remember {
//        mutableStateOf(0)
//    }
//
//    var key = count.value%3==0;
//    LaunchedEffect(key1 = key) {
//        Log.d("Counter", "Current Count: ${count.value}")
//    }
//    Button(onClick = { count.value++ }) {
//        Text(text = "Counter Incrementer")
//
//    }
//}

// launched effect only runs one time and re runs when the value of unit has been changed.
@Composable
fun ListComposable() {
    var categoryState = remember {
        mutableStateOf(emptyList<String>())
    }
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategory();
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }
}

fun fetchCategory(): List<String> {
    return listOf("One", "two", "three")
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


//Understanding recomposable in jetpack composes
@Composable
fun Recomposable() {
    val state = remember {
        mutableStateOf(0.0)
    }
    Log.d("Tagged", "Called with initial composition")
    Button(onClick = { state.value = Math.random() }) {
        Log.d("Tagged", "Logged with composition and recomposition")
        Text(text = state.value.toString())
    }
}







