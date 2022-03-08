package com.epicdevler.stockin.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.epicdevler.stockin.R
import com.epicdevler.stockin.ui.theme.PurplePrimary

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    tint: Color = PurplePrimary,
    src: Painter = painterResource(id = R.drawable.ic_stockin_white)
) {
    Image(
        painter = src,
        contentDescription = "Official Company Logo",
        modifier = modifier.fillMaxWidth(),
        colorFilter = ColorFilter.tint(color = tint)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LogoPrev() = Column {
    Logo()
}
