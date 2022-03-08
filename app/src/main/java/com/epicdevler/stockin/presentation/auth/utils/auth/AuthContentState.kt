package com.epicdevler.stockin.presentation.auth.utils.auth

data class AuthContentState(val state: UIState) {
    sealed class UIState(var title: String, var subTitle: String) {
        object SignIn : UIState(
            "Login to continue",
            "Enter the following credentials to kickstart your registration process."
        )

        object SignUp : UIState(
            "Register to continue",
            "Enter the following credentials to kickstart your registration process."
        )

        object VerifyEmail : UIState(
            "Verify your Email",
            "A verification code has been sent to your email reginaldabiepepple@gmail.com"
        )
    }
}
