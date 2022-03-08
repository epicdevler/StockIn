package com.epicdevler.stockin.presentation.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.epicdevler.stockin.R
import com.epicdevler.stockin.ui.theme.PurplePrimary

@Composable
fun Icons(iconType: IconType) {
    val icon = when (iconType) {
        is IconType.Password -> painterResource(id = R.drawable.ic_st_lock)
        is IconType.Email -> painterResource(id = R.drawable.ic_st_mail)
        is IconType.FullName -> painterResource(id = R.drawable.ic_st_edit_name)
//        is IconType.Number -> androidx.compose.material.icons.Icons.Outlined.Phone
//        is IconType.SecurityCode -> androidx.compose.material.icons.Icons.Outlined.Lock
//        is IconType.ExpiryDate -> androidx.compose.material.icons.Icons.Outlined.DateRange
//        is IconType.Card -> androidx.compose.material.icons.Icons.Outlined.ShoppingCart
//        is IconType.Building -> androidx.compose.material.icons.Icons.Outlined.Lock
//        is IconType.Link -> androidx.compose.material.icons.Icons.Outlined.Lock
        else -> painterResource(id = R.drawable.ic_st_edit_name)
    }
    Icon(painter = icon, contentDescription = iconType.description, tint = PurplePrimary)
}