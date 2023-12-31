@file:OptIn(ExperimentalFoundationApi::class)

package com.mariovg.recycler

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariovg.recycler.model.SuperHeroe
import kotlinx.coroutines.launch

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
            ItemHero(heroe = superheroe) {
                Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()

            }

        }
    }

}

@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superHeroes: Map<String, List<SuperHeroe>> = getSuperHeroe().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHeroes.forEach { (publisher, mySsuperheroe) ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 20.sp,
                    color = Color.White
                )

            }
            items(mySsuperheroe) { superheroe ->
                ItemHero(heroe = superheroe) {
                    Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()

                }

            }


        }
    }

}


@Composable
fun SuperHeroeWithSpecialContentiew() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column() {
        LazyColumn(
            state = rvState, verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroe()) { superheroe ->
                ItemHero(heroe = superheroe) {
                    Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()
                }

            }

        }
        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showbutton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un botón cool")
            }

        }


    }


}

@Composable
fun SuperHeroeGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHeroe()) { superheroe ->
            ItemHero(heroe = superheroe) {
                Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()

            }

        }
    })

}

@Composable
fun ItemHero(heroe: SuperHeroe, onItemSelected: (SuperHeroe) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(heroe) }
            .padding(vertical = 8.dp, horizontal = 8.dp)) {
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
