package com.example.versions10

import androidx.annotation.Keep
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi


@Keep
@Composable
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun SetupNavigationHost(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
    )
    {
        composable(
            Screen.MainScreen.route,
            deepLinks = listOf(navDeepLink { uriPattern = Screen.MainScreen.deepLinkRoute })
        ) {
            HomeScreen(
                navController = navController
            )
        }


        composable(
            Screen.ShowTimeslotDetails.route,
            arguments = listOf(
                navArgument("id") {}
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")
                ?.let {
                    val viewModel: TimeslotViewModel = assistedViewModel {
                        TimeslotViewModel.provideFactory(timeslotViewModelFactory(), it.toInt())
                    }
                    ShowTimeslotDetails(
                        timeslotId = it.toInt(),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
        }


    }
}
