package com.epicdevler.stockin.presentation.auth.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.stockin.R
import com.epicdevler.stockin.globUtils.AuthNavigation
import com.epicdevler.stockin.presentation.components.*
import kotlinx.coroutines.launch

@Composable
fun OTPTextFields(
    modifier: Modifier = Modifier,
    length: Int,
    onFilled: (code: String) -> Unit
) {
    var code: List<Char> by remember { mutableStateOf(listOf()) }
    val focusRequesters: List<FocusRequester> = remember {
        val temp = mutableListOf<FocusRequester>()
        repeat(length) {
            temp.add(FocusRequester())
        }
        temp
    }

    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        (0 until length).forEach { index ->
            OutlinedTextField(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .focusOrder(focusRequester = focusRequesters[index]) {
                        focusRequesters[index + 1].requestFocus()
                    },
                textStyle = MaterialTheme.typography.body2.copy(
                    textAlign = TextAlign.Center, color = Color.Black
                ),
                singleLine = true,
                value = code.getOrNull(index = index)?.takeIf {
                    it.isDigit()
                }?.toString() ?: "",
                onValueChange = { value: String ->
                    if (focusRequesters[index].freeFocus()) {
                        val temp = code.toMutableList()
                        if (value == "") {
                            if (temp.size > index) {
                                temp.removeAt(index = index)
                                code = temp
                                focusRequesters.getOrNull(index - 1)?.requestFocus()
                            }
                        } else {
                            if (code.size > index) {
                                temp[index] = value.getOrNull(0) ?: ' '
                            } else {
                                temp.add(value.getOrNull(0) ?: ' ')
                                code = temp
                                focusRequesters.getOrNull(index + 1)?.requestFocus() ?: onFilled(
                                    code.joinToString(separator = "")
                                )
                            }
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

@Composable
fun EmailVerification(
    navController: NavController? = null,
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val title = remember { mutableStateOf(R.string.verify_screen_title) }
    val subTitle =
        remember { mutableStateOf(R.string.verify_screen_msg) }
    val otpVal: String? = null
 Scaffold(scaffoldState = scaffoldState) {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .verticalScroll(rememberScrollState())
             .padding(16.dp)
     ) {

         Logo(modifier = Modifier.padding(vertical = 64.dp))
         H1(text = stringResource(id = title.value))
         BodyText(
             text = stringResource(id = subTitle.value),
             modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
         )
         OTPTextFields(
             length = 4
         ) { getOpt ->
             otpVal
         }
         //        VERIFY BUTTON
         FilledButton(
             onClick = {
                 coroutineScope.launch {
                     scaffoldState.snackbarHostState
                         .showSnackbar(message = "Verify", duration = SnackbarDuration.Long)
                 }
             },
             text = stringResource(R.string.register_label),
             modifier = Modifier.padding(top = 32.dp)
         )

//        TO RESEND OTP BUTTON

         SplitButton(
             onClick = { navController?.navigate(AuthNavigation.EmailVerification.route) },
             actionText = stringResource(R.string.resend_label),
             label = stringResource(R.string.didnt_receive_otp_label),
             modifier = Modifier.padding(top = 16.dp)
         )

     }
 }
}