package ca.uptabusiness.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ca.uptabusiness.ui.components.gridlayout.PhotoGrid
import ca.uptabusiness.viewmodels.UpTaBusinessEvent
import ca.uptabusiness.viewmodels.UpTaBusinessViewModel
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpTaBusinessFoodContent(
    viewModel: UpTaBusinessViewModel = UpTaBusinessViewModel()
) {

    val pullRefreshState = rememberPullRefreshState(
        false,
        { viewModel.onEvent(UpTaBusinessEvent.RefreshFood) }
    )

    val pictureToOpen = remember {
        mutableStateOf<Int?>(null)
    }

    if (pictureToOpen.value != null) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            AsyncImage(
                model = pictureToOpen.value,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        pictureToOpen.value = null
                    }
                    .align(Alignment.TopEnd),
                tint = Color.White
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ) {
            PhotoGrid(
                photos = viewModel.foodState,
                onPhotoSelected = {
                    pictureToOpen.value = it
                }
            )
            PullRefreshIndicator(
                false,
                pullRefreshState,
                Modifier.align(Alignment.TopCenter)
            )
        }
    }
}
