package com.example.composelearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Screen {

//    @Preview(heightDp = 500)
    @Composable
    fun PreviewItem() {
//        BlogCategory(img = R.drawable.baseline_person, name = "John Doe", title = "Programming")

        // this will render all items in a list and not re-render like recycler view.
//        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//            getList().map {
//                item -> BlogCategory(img = item.img, name = item.name, title = item.title)
//            }
//        }

        // this is equivalent to recycler view.
        LazyColumn(
            content = {
                items(getList()){ item ->  // Correct lambda syntax
                    BlogCategory(img = item.img, name = item.name, title = item.title)
                }
            }
        )

    }

    @Composable
    fun BlogCategory(img: Int, name: String, title: String) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .weight(.2f),
                    painter = painterResource(id = img),
                    contentDescription = "",

                    )
                ItemDescription(name, title, Modifier.weight(.8f))
            }


        }
    }


    @Composable
    private fun ItemDescription(name: String, title: String, modifier: Modifier) {
        Column(modifier = modifier) {
            Text(text = name, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Thin
            )
        }
    }

    data class Category(val img: Int, val name: String, val title: String)

    fun getList(): MutableList<Category> {
        val list = mutableListOf<Category>()

        list.add(Category(R.drawable.baseline_person, "John Doe", "Programmer"))
        list.add(Category(R.drawable.baseline_person, "John Parker", "Dev Ops"))

        list.add(
            Category(
                R.drawable.baseline_person,
                "Samantha",
                "Construction"
            )
        )
        list.add(Category(R.drawable.baseline_person, "Chandler", "HR"))
        list.add(Category(R.drawable.baseline_person, "John Doe", "Programmer"))
        list.add(Category(R.drawable.baseline_person, "John Parker", "Dev Ops"))

        list.add(
            Category(
                R.drawable.baseline_person,
                "Samantha",
                "Construction"
            )
        )
        list.add(Category(R.drawable.baseline_person, "Chandler", "HR"))
        return list
    }


}