package ca.uptabusiness.android

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ca.uptabusiness.navigations.AppDrawer
import ca.uptabusiness.navigations.AppNavigationActions
import ca.uptabusiness.navigations.Destinations
import ca.uptabusiness.navigations.toStringId
import ca.uptabusiness.ui.UpTaBusinessEventsContent
import ca.uptabusiness.ui.UpTaBusinessFoodContent
import ca.uptabusiness.ui.UpTaBusinessHomeContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpTaBusinessNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: Destinations.Home.route
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateTo = { destination ->
                when (destination) {
                    Destinations.Home -> navigationActions.navigateToHome()
                    Destinations.Culinary -> navigationActions.navigateToCulinary()
                    Destinations.Events -> navigationActions.navigateToEvents()
                    Destinations.Corporate -> navigationActions.navigateToCorporate()
                    Destinations.Products -> navigationActions.navigateToProducts()
                }
            },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = Destinations.valueOf(currentRoute).toStringId())) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch { drawerState.open() }
                            },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null
                                )
                            })
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Destinations.Home.route,
                modifier = modifier.padding(it)
            ) {
                composable(Destinations.Home.route) {
                    UpTaBusinessHomeContent(
                        onNavigate = { destination ->
                            navController.navigate(route = destination.route)
                        }
                    )
                }

                composable(Destinations.Culinary.route) {
                    UpTaBusinessFoodContent()
                }

                composable(Destinations.Events.route) {
                    UpTaBusinessEventsContent()
                }

                composable(Destinations.Corporate.route) {
                }

                composable(Destinations.Products.route) {
                }
            }
        }
    }
}
