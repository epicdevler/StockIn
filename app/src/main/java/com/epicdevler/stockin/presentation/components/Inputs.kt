package com.epicdevler.stockin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epicdevler.stockin.R
import com.epicdevler.stockin.ui.theme.PurplePrimary

@Composable
fun OutlinedInput(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    singleLine: Boolean = true,
    label: String = "Placeholder",
    placeholder: String = "",
    inputType: InputType = InputType.Email,
) {

    val keyboardType: KeyboardOptions = when (inputType) {
        InputType.Email -> KeyboardOptions(keyboardType = KeyboardType.Email)
        InputType.Password -> KeyboardOptions(keyboardType = KeyboardType.Password)
        InputType.FullName -> KeyboardOptions(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words
        )
        else -> {
            KeyboardOptions(keyboardType = KeyboardType.Text)
        }
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardType,
        singleLine = singleLine,
        leadingIcon = {
            when (inputType) {
                InputType.Email -> {
                    Icons(iconType = IconType.Email)
                }
                InputType.Password -> {
                    Icons(iconType = IconType.Password)
                }
                InputType.FullName -> {
                    Icons(iconType = IconType.FullName)
                }
                else -> {
                    Icons(iconType = IconType.Email)
                }
            }
        },
        label = { LabelText(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PurplePrimary,
            focusedLabelColor = PurplePrimary,
        )
    )
}


@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    singleLine: Boolean = true,
    label: String = "Placeholder",
    placeholder: String = "",
) {
    val showPassword = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = singleLine,
        leadingIcon = { Icons(iconType = IconType.Password) },
        label = { LabelText(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = modifier
            .fillMaxWidth(),
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = when (showPassword.value) {
                true -> {
                    painterResource(id = R.drawable.ic_st_eye_slash)
                }
                else -> {
                    painterResource(id = R.drawable.ic_st_eye)
                }
            }

            IconButton(onClick = { showPassword.value = !showPassword.value }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility",
                    tint = PurplePrimary
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PurplePrimary,
            focusedLabelColor = PurplePrimary,
            cursorColor = PurplePrimary,
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InputPrev() {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    var showPassword = remember { mutableStateOf(false) }
    Column {
        OutlinedInput(
            value = value,
            onValueChange = {
                value = it
            },
            inputType = InputType.Email,
            label = "Email Address"
        )
        PasswordInput(
            value = value,
            onValueChange = {
                value = it
            },
            label = "Password",
        )
    }
}
