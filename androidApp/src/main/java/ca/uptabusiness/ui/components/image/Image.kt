package ca.uptabusiness.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import ca.uptabusiness.android.R

@Composable
fun CircleLogo(
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_uptabusiness),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape),
        contentScale = ContentScale.Fit
    )
}