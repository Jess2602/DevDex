package com.example.devdex.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devdex.R

@Preview(showBackground = true)

@Composable
fun LoginScreen() {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "DevDex",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Empieza tu aventura Pokemon local",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Nombre de usuario")

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Nombre de usuario") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Ej. Trainer Red") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Contraseña")

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Ej. 123") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        FilledTonalButton(onClick = { }, modifier = Modifier.fillMaxWidth()) {
            Text("LOGIN")
        }

        val annotatedString = buildAnnotatedString {
            append("¿No tienes perfil? ")

            withLink(
                LinkAnnotation.Clickable(
                    tag = "Crear Perfil", linkInteractionListener = {
                        // Do something when "Crear Perfil" is clicked
                    })
            ) {
                append("Crear Perfil")
            }
        }

        Text(
            text = annotatedString, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
        )

    }
}