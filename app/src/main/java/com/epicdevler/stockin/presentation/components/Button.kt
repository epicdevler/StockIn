package com.epicdevler.stockin.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FilledButton(modifier: Modifier = Modifier, text: String = "Submit", enabled: Boolean = true, onClick: () -> Unit, ){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth(1f),
        contentPadding = PaddingValues(13.dp),

        ) {
        Text(text = text)
    }
}

@Composable
fun SplitButton(
    modifier: Modifier = Modifier,
    label: String = "Already have an account?",
    actionText: String = "Login",
    enabled: Boolean = true,
    onClick: () -> Unit,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = label)
        TextButton(
            onClick = onClick,
            enabled = enabled,
            modifier = Modifier,
            contentPadding = PaddingValues(10.dp)
        ) {
            Text(text = actionText)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Button Preview")
@Composable
fun BtnPrev() {
    Column {
        H1(text = "Login")
        FilledButton(text = "Login", onClick = {})
        SplitButton(actionText = "Sign Up", label = "Don't have an account?", onClick = {})
    }
}