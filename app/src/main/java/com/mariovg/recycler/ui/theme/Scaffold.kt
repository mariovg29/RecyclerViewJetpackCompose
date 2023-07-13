package com.mariovg.recycler.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScafoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar (onClickIcon = {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    "Has pulsado $it"
                )
            }
        }, onclickDrawer = {
            coroutineScope.launch {
                scaffoldState.drawerState.open()
            }
        })
    }, scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation()},
        floatingActionButton = {MyFloatingActionButton()},
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer(){coroutineScope.launch { scaffoldState.drawerState.close() }} },
        drawerGesturesEnabled =false

        ) {
        {


        }
    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onclickDrawer : () -> Unit) {
    TopAppBar(
        title = { Text("This is my first toolbar") },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 10.dp,
        navigationIcon = {
            IconButton(onClick = {onclickDrawer()  }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("exit") }) {
                Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "exit")
            }
        }
    )


}

@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)}
    BottomNavigation(backgroundColor = Color.Blue, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index=0}, icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "home"
            )
        }, label = {
            Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1}, icon = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "fav"
            )
        }, label = {
            Text(text = "Fav") })
        BottomNavigationItem(selected = index ==2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "person"
            )
        }, label = {
            Text(text = "Profile") })

    }


}
@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = {}, backgroundColor = Color.Yellow, contentColor = Color.Black) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(text = "primera Opcion",Modifier.padding(8.dp).fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() })
        Text(text = "segunda Opcion",Modifier.padding(8.dp).fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() })
        Text(text = "tercera Opcion",Modifier.padding(8.dp).fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() })

    }

}
