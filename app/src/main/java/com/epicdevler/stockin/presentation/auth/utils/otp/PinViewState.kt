package com.epicdevler.stockin.presentation.auth.utils.otp

import androidx.compose.ui.text.input.TextFieldValue

class PinViewState constructor(val otpLength: OtpLength = OtpLength.Four) {

    data class Values(
        var inputOne: TextFieldValue,
        val inputTwo: String = "",
        val inputThree: String = "",
        val inputFour: String = "",
        val inputFive: String = "",
        val inputSix: String = "",
        val inputSeven: String = "",
        val inputEight: String = ""
    ) {
        private val otpLength: OtpLength = OtpLength.Four

    }

    val values = mutableListOf(
        TextFieldValue(""),
        TextFieldValue(""),
        TextFieldValue(""),
        TextFieldValue(""),
        TextFieldValue(""),
        TextFieldValue(""),
        TextFieldValue(""),
    )

    var inputOne: TextFieldValue = TextFieldValue("")
    var inputTwo: TextFieldValue = TextFieldValue("")
    var inputThree: TextFieldValue = TextFieldValue("")
    var inputFour: TextFieldValue = TextFieldValue("")
    var inputFive: TextFieldValue = TextFieldValue("")
    var inputSix: TextFieldValue = TextFieldValue("")
    var inputSeven: TextFieldValue = TextFieldValue("")
    var inputEight: TextFieldValue = TextFieldValue("")

    fun value(): String {
        return when (otpLength) {
            is OtpLength.Four -> {
                "${inputOne.text}${inputTwo.text}${inputThree.text}${inputFour.text}"
            }
            is OtpLength.Six -> {
                "${inputOne.text}${inputTwo.text}${inputThree.text}${inputFour.text}${inputFive.text}${inputSix.text}"
            }
            is OtpLength.Eight -> {
                "${inputOne.text}${inputTwo.text}${inputThree.text}${inputFour.text}${inputFive.text}${inputSix.text}${inputSeven.text}${inputEight.text}"
            }
        }
    }

}