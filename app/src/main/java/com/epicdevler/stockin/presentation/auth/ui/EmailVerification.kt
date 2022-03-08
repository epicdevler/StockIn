package com.epicdevler.stockin.presentation.auth.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.epicdevler.stockin.globUtils.AuthNavigation

@Composable
fun EmailVerification(navController: NavController? = null) {
    Text(text = "Verify Email")
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun EmailVerificationPrev() {
    EmailVerification()
}