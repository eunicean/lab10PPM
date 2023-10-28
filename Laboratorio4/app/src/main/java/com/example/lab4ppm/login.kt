package com.example.lab4ppm

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

var auth: FirebaseAuth = Firebase.auth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(navController: NavController){
    val context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.singin),
        contentDescription = "Login",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
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
            label = { Text(text = "email") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xff4a5759),
                containerColor = Color(0x004a5759),
                unfocusedIndicatorColor = Color(0xff4a5759)
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = pswrdU,
            onValueChange = { pswrdU = it },
            label = { Text(text = "password") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xff4a5759),
                containerColor = Color(0x004a5759),
                unfocusedIndicatorColor = Color(0xff4a5759)
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
        Spacer(modifier = Modifier.height(25.dp))
        clickText(text = "Register", navController = navController, route = AppScreens.SignUpScreen.route, red = 224, green = 122, blue = 95)
    }
}


@Composable
fun clickText(text:String, navController: NavController, route: String, red: Int, green: Int, blue: Int){
    Text(text = text,
        color = Color(red, green, blue),
        fontWeight = FontWeight.Black,
        modifier = Modifier.clickable(onClick = {navController.navigate(route)})
    )
}

fun loginVerification(emailU: String, pswrdU: String, navController: NavController, context: Context) {
    //sacado de GeeksForGeeks https://www.geeksforgeeks.org/login-and-registration-in-android-using-firebase-in-kotlin/
    if(emailU.isBlank() || pswrdU.isBlank()){
        Toast.makeText(context, "Please fill all the spaces", Toast.LENGTH_LONG).show()
        return
    }

    auth.signInWithEmailAndPassword(emailU,pswrdU).addOnCompleteListener {
        if (it.isSuccessful) {
            navController.navigate(route = "profile")

        } else {
            Toast.makeText(context, "Email or password incorrect", Toast.LENGTH_LONG).show()
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    NavigationApp()
}