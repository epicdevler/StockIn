package com.epicdevler.stockin.globUtils

sealed class AuthNavigation(val route: String){
    object SignIn : AuthNavigation("SIGN_IN_SCREEN")
    object SignUp : AuthNavigation("SIGNUP_SCREEN")
    object EmailVerification : AuthNavigation("EMAIL_VERIFICATION_SCREEN")
}
