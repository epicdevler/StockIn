package com.epicdevler.stockin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.epicdevler.stockin.ui.theme.BlackPrimary


@Composable
fun H1(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        style = MaterialTheme.typography.h4,
        color = BlackPrimary,
        fontWeight = FontWeight.W800,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun H2(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.h5,
        color = BlackPrimary,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BodyText(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Center) {
    Text(
        text,
        style = MaterialTheme.typography.subtitle1,
        color = BlackPrimary,
        fontWeight = FontWeight.W500,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun LabelText(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        style = MaterialTheme.typography.subtitle2,
        color = BlackPrimary,
        fontWeight = FontWeight.W500,
        modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Prev() {
    Column {
        H1("Hello")
        H2("Hello")
        BodyText(text = "Hello", textAlign = TextAlign.Start)
        LabelText("Hello")
    }
}