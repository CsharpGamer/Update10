package com.example.versions10

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    val onTimeslotClick = {
        navController.navigate(
            Screen.ShowTimeslotDetails.createRouteWithParameter(
                "1"
            )
        )
    }


    Text("HOme")
    Button(onClick = {onTimeslotClick() }) {

    }
}