package com.mariovg.recycler

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariovg.recycler.model.SuperHeroe

@Composable
fun SimpleRecycler() {
    val myList = listOf("Mario", "Antonio", "Valadez", "Perez", "Garcia")
    LazyColumn {
        item {
            Text(text = "Header")

        }
        items(10) {
            Text(text = "Hola me llamo Item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo Item $it")
        }
        item {
            Text(text = "Footer")

        }
    }
}

@Composable
fun SuperHeroeView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroe()) { superheroe ->
            ItemHero(heroe = superheroe){
                Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()

            }

        }
    }

}

@Composable
fun ItemHero(heroe: SuperHeroe, onItemSelected: (SuperHeroe) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(heroe) }) {
        Column {
            Image(
                painter = painterResource(id = heroe.photo),
                contentDescription = "SuperHeroe Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = heroe.superHeroeName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = heroe.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = heroe.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )

        }

    }
}

fun getSuperHeroe(): List<SuperHeroe> {
    return listOf(
        SuperHeroe("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHeroe("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHeroe("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHeroe("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHeroe("Flash", "Barry Allen", "DC", R.drawable.flash),
        SuperHeroe("Green Lantern", "Hal Jordan", "DC", R.drawable.green_lantern),
        SuperHeroe("Wonder Woman", "Diana Prince", "DC", R.drawable.wonder_woman)

    )
}
