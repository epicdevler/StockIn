package com.epicdevler.stockin.presentation.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.epicdevler.stockin.globUtils.AuthNavigation
import com.epicdevler.stockin.presentation.auth.ui.EmailVerification
import com.epicdevler.stockin.presentation.auth.ui.SignIn
import com.epicdevler.stockin.presentation.auth.ui.SignUp
import com.epicdevler.stockin.presentation.auth.utils.auth.AuthViewModel
import com.epicdevler.stockin.ui.theme.StockinTheme

class AuthActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            StockinTheme {
                AuthUI()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun AuthUI() {
    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel()
    val localFocusManager = LocalFocusManager.current
    NavHost(
        navController = navController,
        startDestination = AuthNavigation.SignIn.route,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                localFocusManager.clearFocus()
            })
        }) {
        composable(route = AuthNavigation.SignIn.route) {
            SignIn(navController, viewModel)
        }
        composable(route = AuthNavigation.SignUp.route) {
            SignUp(navController, viewModel)
        }
        composable(route = AuthNavigation.EmailVerification.route) {
            EmailVerification(navController)
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthActivityPre() {
    AuthUI()
}
