package com.epicdevler.stockin.presentation.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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

@Composable
fun AuthUI() {
    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel()
        NavHost(navController = navController, startDestination = AuthNavigation.SignIn.route) {
            composable(route = AuthNavigation.SignIn.route) {
                SignIn(navController, viewModel)
            }
            composable(route = AuthNavigation.SignUp.route) {
                SignUp(navController, viewModel)
            }
            composable(route = AuthNavigation.EmailVerification.route) {
                EmailVerification(navController, /*viewModel*/)
            }
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthActivityPre() {
    AuthUI()
}
