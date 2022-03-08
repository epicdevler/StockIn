package com.epicdevler.stockin.presentation.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.stockin.R
import com.epicdevler.stockin.presentation.auth.utils.auth.AuthContentState
import com.epicdevler.stockin.presentation.auth.utils.auth.AuthViewModel
import com.epicdevler.stockin.presentation.components.*
import kotlinx.coroutines.launch

@Composable
fun SignUp(navController: NavController? = null, viewModel: AuthViewModel? = null) {

    viewModel!!.setUiContent(AuthContentState(state = AuthContentState.UIState.SignIn))
    val title = remember { mutableStateOf("Register to continue") }
    val subTitle =
        remember { mutableStateOf("Enter the following credentials to kickstart your registration process.") }

    var fullNameValue by remember { mutableStateOf(TextFieldValue("")) }
    var emailValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Logo(modifier = Modifier.padding(vertical = 64.dp))
            H1(text = title.value)
            BodyText(
                text = subTitle.value,
                modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
            )
//        FULL NAME INPUT VIEW
            OutlinedInput(
                value = fullNameValue,
                onValueChange = { fullNameValue = it },
                inputType = InputType.FullName,
                label = stringResource(R.string.full_name_label),
            )
//          EMAIL INPUT VIEW
            OutlinedInput(
                value = emailValue,
                onValueChange = { emailValue = it },
                inputType = InputType.Email,
                label = stringResource(R.string.email_address_label),
            )
//        PASSWORD INPUT VIEW
            PasswordInput(
                value = passwordValue, onValueChange = { passwordValue = it },
                label = stringResource(
                    R.string.password_label
                )
            )
//        REGISTER BUTTON
            FilledButton(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar(message = "Hello world", duration = SnackbarDuration.Long)
                    }
                },
                text = stringResource(R.string.register_label),
                modifier = Modifier.padding(top = 32.dp)
            )

//        TO LOGIN SCREEN BUTTON

            SplitButton(
                onClick = { navController?.navigateUp() },
                actionText = stringResource(R.string.login_label),
                label = stringResource(R.string.already_have_an_account_label),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SignUPPrev() {
    SignUp()
}