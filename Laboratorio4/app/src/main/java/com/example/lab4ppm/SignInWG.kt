package com.example.lab4ppm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit,
    navController: NavController
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInErrorMessage) {
        state.signInErrorMessage?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Image(
        painter = painterResource(id = R.drawable.singin),
        contentDescription = "Login",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(35.dp))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var emailU by rememberSaveable {
            mutableStateOf("")
        }
        var pswrdU by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = emailU,
            onValueChange = { emailU = it },
            label = { Text(
                text = "email",
                color = Color(0xfff28482)
            ) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xfff28482),
                containerColor = Color(0x004a5759),
                unfocusedIndicatorColor = Color(0xfff28482)
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = pswrdU,
            onValueChange = { pswrdU = it },
            label = { Text(
                text = "password",
                color = Color(0xfff28482)
            ) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xfff28482),
                containerColor = Color(0x004a5759),
                unfocusedIndicatorColor = Color(0xfff28482)
            )
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .width(190.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff28482)
            ),
            onClick = {
                loginVerification(emailU, pswrdU, navController,context) }
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .width(190.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff28482)
            ),
            onClick = onSignInClick
        ) {
            Text(text = "Login with Gooogle")
        }

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .width(190.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff28482)
            ),
            onClick = { navController.navigate(route = AppScreens.SignUpScreen.route) }
        ) {
            Text(text = "Register new account",
                color = Color(255, 220, 220, 255)
            )
        }
    }
}
