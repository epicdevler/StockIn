package com.epicdevler.stockin.presentation.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epicdevler.stockin.presentation.auth.utils.otp.PinViewState
import com.epicdevler.stockin.ui.theme.BlackPrimary
import com.epicdevler.stockin.ui.theme.BorderPrimary
import com.epicdevler.stockin.ui.theme.GrayShadePrimary

@ExperimentalComposeUiApi
@Composable
fun PinView(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    localFocusManager: FocusManager = LocalFocusManager.current,
    isLastPin: Boolean = false
) {
    val width = 60
    val height = 60
    val imeAction: ImeAction = when (isLastPin) {
        true -> ImeAction.Done
        else -> ImeAction.Next
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .width(width.dp)
            .onKeyEvent {
                when (it.key) {
                    Key.Backspace -> {
                        localFocusManager.moveFocus(FocusDirection.Left)
                        true
                    }
                    else -> false
                }
            },
        placeholder = { H2(text = "0", color = GrayShadePrimary) },
        textStyle = TextStyle(
            textAlign = TextAlign.Center, fontWeight = FontWeight.W700,
            color = BlackPrimary, fontSize = 24.sp,
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                localFocusManager.moveFocus(FocusDirection.Right)
            },
            onDone = {
                localFocusManager.clearFocus()
            }
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = BorderPrimary
        ),
    )
}

@ExperimentalComposeUiApi
@Composable
fun Pin(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isLastPin: Boolean = false
) {
    val width = 60
    val height = 60
    val imeAction: ImeAction = when (isLastPin) {
        true -> ImeAction.Done
        else -> ImeAction.Next
    }
    val localFocusManager1 = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .width(width.dp)
            .onKeyEvent {
                when (it.key) {
                    Key.Backspace -> {
                        localFocusManager1.moveFocus(FocusDirection.Left)
                        true
                    }
                    else -> false
                }
            },
        placeholder = { H2(text = "0", color = GrayShadePrimary) },
        textStyle = TextStyle(
            textAlign = TextAlign.Center, fontWeight = FontWeight.W700,
            color = BlackPrimary, fontSize = 24.sp,
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                localFocusManager1.moveFocus(FocusDirection.Right)
            },
            onDone = {
                localFocusManager1.clearFocus()
            }
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = BorderPrimary
        ),
    )
}

@ExperimentalComposeUiApi
@Preview(showBackground = true, showSystemUi = true, name = "Pin View Preview")
@Composable
fun PinViewPreview() {
    var pin by remember { mutableStateOf(TextFieldValue("")) }
    PinView(
        value = pin,
        onValueChange = { pin = it }
    )
}