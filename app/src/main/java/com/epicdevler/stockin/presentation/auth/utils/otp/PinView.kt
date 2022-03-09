package com.epicdevler.stockin.presentation.auth.utils.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import com.epicdevler.stockin.presentation.components.Pin

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PView(
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    otpLength: OtpLength = OtpLength.Four,
    focusManager: FocusManager,
    value: PinViewState
) {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = horizontalArrangement) {
        var isLast = false
        val lastItem = otpLength.count - 1
        val maxInputLength = 1
        val values = value.values
        repeat(otpLength.count) { index ->
            when (index) {
                otpLength.count - 1 -> isLast = true
            }
            Pin(value = values[index], onValueChange = {
                if (values[index].text.length >= maxInputLength) {
                    when (index) {
                        0 -> {
                            value.inputOne = it
                        }
                        1 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputTwo = it
                        }
                        2 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputThree = it
                        }
                        3 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputFour = it
                        }
                        4 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputFive = it
                        }
                        5 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputSix = it
                        }
                        6 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputSeven = it
                        }
                        7 -> {
                            if (it.text.isNotEmpty() && it.text.length == maxInputLength) {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                            value.inputEight = it
                        }
                    }
                }
            }, isLastPin = isLast)
        }
    }
}