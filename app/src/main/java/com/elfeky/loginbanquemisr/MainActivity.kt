package com.elfeky.loginbanquemisr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.loginbanquemisr.components.ServiceSection
import com.elfeky.loginbanquemisr.ui.theme.LightRed
import com.elfeky.loginbanquemisr.ui.theme.LogInBanqueMisrTheme
import com.elfeky.loginbanquemisr.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogInBanqueMisrTheme {
                LogInScreen()
            }
        }
    }
}

@Composable
fun LogInScreen(modifier: Modifier = Modifier) {
    // Make Status Bar Transparent
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.Transparent)

    // Manage TextFields
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    var passwordVisibility by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)

    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = "Bank Misr"
            )
            Text(
                text = stringResource(R.string.language),
                fontWeight = FontWeight.Bold,
                color = Red,
                style = MaterialTheme.typography.titleMedium
            )

        }
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = stringResource(R.string.username)) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Red,
                focusedLabelColor = Red
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Password TextField
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.password)) },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    val icon =
                        if (passwordVisibility) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
                    Icon(imageVector = icon, contentDescription = "password visibility")
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Red,
                focusedLabelColor = Red
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.forgot_username_password),
            textDecoration = TextDecoration.Underline,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onClick = { },
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Red,
                disabledContentColor = Color.White,
                disabledContainerColor = LightRed
            ),
            // Condition to make Button enabled
            enabled = (username.text.isNotEmpty() and password.text.isNotEmpty()),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.login)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.need_help))
                withStyle(style = SpanStyle(
                    color = Red,
                    textDecoration = TextDecoration.Underline
                    )){
                    append(stringResource(R.string.contact_us))
                }
            },
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))
        ServiceSection(
            serviceList = listOf(
                Service(
                    R.drawable.our_products,
                    stringResource(R.string.our_products)
                ),
                Service(
                    R.drawable.exchange_rate,
                    stringResource(R.string.exchange_rate)
                ),
                Service(
                    R.drawable.security_tips,
                    stringResource(R.string.security_tips)
                ),
                Service(
                    R.drawable.nearest_branch_or_atm,
                    stringResource(R.string.nearest_branch_or_atm)
                )
            )
        )

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenPreview() {
    LogInBanqueMisrTheme {
        LogInScreen()
    }
}