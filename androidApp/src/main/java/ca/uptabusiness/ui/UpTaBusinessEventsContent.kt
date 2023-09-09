package ca.uptabusiness.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ca.uptabusiness.ui.components.gridlayout.PhotoGrid
import ca.uptabusiness.viewmodels.UpTaBusinessEvent
import ca.uptabusiness.viewmodels.UpTaBusinessViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpTaBusinessEventsContent(
    viewModel: UpTaBusinessViewModel = UpTaBusinessViewModel()
) {

    val pullRefreshState = rememberPullRefreshState(
        false,
        { viewModel.onEvent(UpTaBusinessEvent.RefreshEvents) }
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .pullRefresh(pullRefreshState)) {
        PhotoGrid(photos = viewModel.eventsState)
        PullRefreshIndicator(
            false,
            pullRefreshState,
            Modifier.align(Alignment.TopCenter)
        )
    }
}