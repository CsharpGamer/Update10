package com.example.versions10

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@Composable
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun ShowTimeslotDetails(
    timeslotId: Int, // Used only for Logging
    viewModel: TimeslotViewModel, navController: NavController
) {
    Text("timeslot")
}