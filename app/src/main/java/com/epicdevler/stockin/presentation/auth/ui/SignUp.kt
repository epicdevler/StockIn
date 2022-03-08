package com.epicdevler.stockin.presentation.auth.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SignUp(navController: NavController? = null) {
    Text(text = "Sign Up")
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SignUPPrev() {
    SignUp()
}