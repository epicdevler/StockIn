package com.epicdevler.stockin.presentation.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.epicdevler.stockin.presentation.auth.utils.otp.PView
import com.epicdevler.stockin.presentation.auth.utils.otp.PinViewState

@ExperimentalComposeUiApi
@Composable
fun EmailVerification(
    navController: NavController? = null,
    localFocusManager: FocusManager? = null
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val inputMaxLength: Int = 1
        var pin1 by remember { mutableStateOf(TextFieldValue("")) }
        var pin2 by remember { mutableStateOf(TextFieldValue("")) }
        var pin3 by remember { mutableStateOf(TextFieldValue("")) }
        var pin4 by remember { mutableStateOf(TextFieldValue("")) }

        val value by remember {
            mutableStateOf(PinViewState())
        }

        Text(text = "Verify Email")
        /*Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
            PinView(
                value = pin1,
                onValueChange = {
                    if (it.text.length <= inputMaxLength) pin1 = it
                    if (it.text.isNotEmpty() && it.text.length == 1) {
                        localFocusManager!!.moveFocus(FocusDirection.Right)
                    }
                },
                localFocusManager!!
            )
            PinView(
                value = pin2,
                onValueChange = {
                    if (it.text.length <= inputMaxLength) pin2 = it
                    if (it.text.isNotEmpty() && it.text.length == 1) {
                        localFocusManager.moveFocus(FocusDirection.Right)
                    }
                },
                localFocusManager = localFocusManager
            )
            PinView(
                value = pin3,
                onValueChange = {
                    if (it.text.length <= inputMaxLength) pin3 = it
                    if (it.text.isNotEmpty() && it.text.length == 1) {
                        localFocusManager.moveFocus(FocusDirection.Right)
                    }
                },
                localFocusManager = localFocusManager
            )
            PinView(
                value = pin4,
                onValueChange = {
                    if (it.text.length <= inputMaxLength) pin4 = it
                },
                localFocusManager = localFocusManager,
                isLastPin = true
            )
        }*/
        PView(value = value, focusManager = localFocusManager!!)
    }
}

@ExperimentalComposeUiApi
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun EmailVerificationPrev() {
    EmailVerification()
}