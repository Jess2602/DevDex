package com.example.devdex.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devdex.R
import com.example.devdex.data.model.Avatar

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val avatarList = listOf(
        Avatar(id = 1, imageId = R.drawable.pikachu),
        Avatar(id = 2, imageId = R.drawable.bulbasaur),
        Avatar(id = 3, imageId = R.drawable.charmander),
        Avatar(id = 4, imageId = R.drawable.evee),
        Avatar(id = 5, imageId = R.drawable.gengar),
        Avatar(id = 6, imageId = R.drawable.squirtle),
    )
    var selectedAvatar by remember { mutableStateOf<Avatar?>(null) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "",
                alignment = Alignment.Center,
                modifier = Modifier.size(90.dp),
            )
        }

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

        Spacer(modifier = Modifier.height(20.dp))

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

        Text(text = "Correo electrónico")

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "entrenador@ejemplo.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Elige tu Avatar")

        Spacer(modifier = Modifier.height(16.dp))
//aqui va el scroll de fotos de perfil
        LazyRow(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            userScrollEnabled = true,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(avatarList) { item ->
                val isSelected = item == selectedAvatar
                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(70.dp)
                        .clickable(
                            enabled = true, onClick = { selectedAvatar = item })
                        .then(
                            if (isSelected) {
                                Modifier.border(
                                    width = 2.dp,
                                    shape = CircleShape,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            } else {
                                Modifier
                            }
                        )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        FilledTonalButton(onClick = { }, modifier = Modifier.fillMaxWidth()) {
            Text("CREAR PERFIL")
        }

        val annotatedString = buildAnnotatedString {
            append("¿Ya tienes perfil? ")

            withLink(
                LinkAnnotation.Clickable(
                    tag = "Iniciar sesión", linkInteractionListener = {
                        //navController.navigate("login_screen")
                    })
            ) {
                append("Iniciar sesión")
            }
        }

        Text(
            text = annotatedString, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "O continuar con",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_rounded),
                contentDescription = "Google sign in",
                alignment = Alignment.Center,
                modifier = Modifier.size(48.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(id = R.drawable.apple_rounded),
                contentDescription = "Apple sign in",
                alignment = Alignment.Center,
            )
        }
    }
}