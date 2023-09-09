package ca.uptabusiness.navigations

import androidx.annotation.StringRes
import androidx.navigation.NavHostController
import ca.uptabusiness.android.R
import ca.uptabusiness.navigations.Destinations.Culinary
import ca.uptabusiness.navigations.Destinations.Events
import ca.uptabusiness.navigations.Destinations.Home
import ca.uptabusiness.navigations.Destinations.Products
import ca.uptabusiness.navigations.Destinations.Corporate

enum class Destinations(val route: String) {
    Home(route = "Home"),
    Culinary(route = "Culinary"),
    Events(route = "Events"),
    Products(route = "Products"),
    Corporate(route = "Corporate")
}

@StringRes
fun Destinations.toStringId(): Int {
    return when(this){
        Home -> R.string.home
        Culinary -> R.string.culinary
        Events -> R.string.events
        Products -> R.string.product
        Corporate -> R.string.corporate
    }
}

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(Home.route) {
            launchSingleTop = true
        }
    }

    fun navigateToCulinary() {
        navController.navigate(Culinary.route) {
            launchSingleTop = true
        }
    }

    fun navigateToEvents() {
        navController.navigate(Events.route) {
            launchSingleTop = true
        }
    }

    fun navigateToProducts() {
        navController.navigate(Products.route) {
            launchSingleTop = true
        }
    }

    fun navigateToCorporate() {
        navController.navigate(Corporate.route) {
            launchSingleTop = true
        }
    }
}
