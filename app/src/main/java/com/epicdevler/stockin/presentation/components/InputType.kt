package com.epicdevler.stockin.presentation.components

import androidx.compose.runtime.Composable

sealed class InputType(val icon: @Composable (() -> Unit)? = null) {
    object Password : InputType(icon = { Icons(iconType = IconType.Password) })
    object Email : InputType(icon = { Icons(iconType = IconType.Email) })
    object FullName : InputType(icon = { Icons(iconType = IconType.FullName) })
    object Number : InputType(icon = { Icons(iconType = IconType.Number) })
    object Card : InputType(icon = { Icons(iconType = IconType.Card) })
    object ExpiryDate : InputType(icon = { Icons(iconType = IconType.ExpiryDate) })
    object OTP : InputType()
}
