package ca.uptabusiness.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.uptabusiness.android.R
import ca.uptabusiness.navigations.Destinations
import ca.uptabusiness.ui.components.image.CircleLogo
import ca.uptabusiness.viewmodels.UpTaBusinessViewModel

@Composable
fun UpTaBusinessHomeContent(
    viewModel: UpTaBusinessViewModel = UpTaBusinessViewModel(),
    onNavigate: (Destinations) -> Unit
) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp))
                    .background(color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircleLogo(modifier = Modifier.size(150.dp))

                    Text(
                        text = stringResource(id = R.string.motto),
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.portfolio),
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                fontFamily = FontFamily.Default,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp),
                color = MaterialTheme.colorScheme.onSurface
            )

            Button(onClick = { onNavigate(Destinations.Culinary) }) {
                Text(
                    text = stringResource(id = R.string.culinary),
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
                )
            }

            Button(onClick = { onNavigate(Destinations.Events) }) {
                Text(
                    text = stringResource(id = R.string.events),
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
                )
            }

            Button(onClick = { onNavigate(Destinations.Events) }) {
                Text(
                    text = stringResource(id = R.string.product),
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
                )
            }
        }
    }
}
