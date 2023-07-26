package com.mariovg.recycler.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Pantalla1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("pantalla2") })
    }

}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("pantalla3") })
    }

}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("pantalla4/234") })
    }

}

@Composable
fun Screen4(navController: NavHostController, name: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = name.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("pantalla1") })
    }

}