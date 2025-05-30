package com.example.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.components.DataField
import com.example.weatherapp.ui.components.PasswordField


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmpassword by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as? Activity
    Column(
        modifier = modifier.padding(12.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = "Bem-vindo/a! Faça seu cadastro",
            fontSize = 24.sp
        )
        DataField(
            label = "Digite seu nome",
            value = name,
            onValueChange = { name = it },
            modifier = modifier.fillMaxWidth(fraction = 0.9f)
        )

        DataField(
            label = "Digite seu e-mail",
            value = email,
            onValueChange = { email = it },
            modifier = modifier.fillMaxWidth(fraction = 0.9f)
        )

        PasswordField(
            label = "Digite sua senha",
            value = password,
            onValueChange = { password = it },
            modifier = modifier.fillMaxWidth(fraction = 0.9f)
        )

        PasswordField(
            label = "Repita sua senha",
            value = confirmpassword,
            onValueChange = { confirmpassword = it },
            modifier = modifier.fillMaxWidth(fraction = 0.9f)
        )

        Column(modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally,) {
            Button(
                onClick = {
                    Toast.makeText(activity, "Registro OK!", Toast.LENGTH_LONG).show()
                    activity?.finish()
                },
                enabled = email.isNotEmpty() && password.isNotEmpty()

            ) {
                Text("Registrar")
            }
            Spacer(modifier = modifier.size(24.dp))
            Button(
                onClick = { email = ""; password = "" }
            ) {
                Text("Limpar")
            }

        }
    }
}