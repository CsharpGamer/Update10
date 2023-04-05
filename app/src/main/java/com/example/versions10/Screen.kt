package com.example.versions10

sealed class Screen(val route: String, val deepLinkRoute: String, val title: String) {

    object MainScreen :
        Screen("MainScreen", DeeplinkUri.DEEPLINKURI.plus("MainScreen"), "main")


    object ShowTimeslotDetails :
        Screen(
            "ShowTimeslotDetails/{id}",
            DeeplinkUri.DEEPLINKURI.plus("ShowTimeslotDetails"),
            "Timeslot Details"
        ) {
        fun createRouteWithParameter(id: String) =
            route.replace("{id}", id)
    }

}
//For deeplinking
object DeeplinkUri {
    const val DEEPLINKURI: String = "x://www.a.com/"
}