package ca.uptabusiness.navigations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ca.uptabusiness.android.R
import ca.uptabusiness.ui.components.image.CircleLogo

@Composable
fun AppDrawer(
    route: String,
    modifier: Modifier = Modifier,
    navigateTo: (Destinations) -> Unit = {},
    closeDrawer: () -> Unit = {}
) {
    ModalDrawerSheet(modifier = Modifier) {
        DrawerHeader(modifier)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.home),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == Destinations.Home.route,
            onClick = {
                navigateTo(Destinations.Home)
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.culinary),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == Destinations.Culinary.route,
            onClick = {
                navigateTo(Destinations.Culinary)
                closeDrawer()
            },
            icon = { Icon(painterResource(id = R.drawable.food), contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.events),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == Destinations.Events.route,
            onClick = {
                navigateTo(Destinations.Events)
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Place, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.corporate),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == Destinations.Corporate.route,
            onClick = {
                navigateTo(Destinations.Corporate)
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(id = R.string.product),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = route == Destinations.Products.route,
            onClick = {
                navigateTo(Destinations.Products)
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )
    }
}


@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(id = R.dimen.header_padding))
            .fillMaxWidth()
    ) {

        CircleLogo(modifier = Modifier.size(dimensionResource(id = R.dimen.header_image_size)))
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_padding)))

        Text(
            text = "Propulse ta business",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    AppDrawer(modifier = Modifier, route = Destinations.Home.route)
}