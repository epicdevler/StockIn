package com.epicdevler.stockin.presentation.components

sealed class IconType(val description: String) {
    object Password : IconType(description = "Password Icon")
    object Email : IconType(description = "Email Icon")
    object FullName : IconType(description = "Full Name Icon")
    object Number : IconType(description = "Number Icon")
    object Card : IconType(description = "Card Icon")
    object ExpiryDate : IconType(description = "Expiry Date Icon")
    object SecurityCode : IconType(description = "Security Code Icon")
    object Link : IconType(description = "Link Icon")
    object Building : IconType(description = "Building Icon")
}
