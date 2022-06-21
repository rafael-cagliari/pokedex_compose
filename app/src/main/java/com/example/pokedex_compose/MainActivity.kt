package com.example.pokedex_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex_compose.ui.theme.Pokedex_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex_composeTheme {
                PokemonCard(
                    "Bulbassaur",
                    "001",
                    R.drawable.ic_01,
                    MaterialTheme.colors.secondaryVariant,
                    R.drawable.ic_grass,
                    null
                )
            }
        }
    }

    @Composable
    fun PokemonCard(
        name: String, pokedexNumber: String,
        @DrawableRes picture: Int, backgroundColor: Color, @DrawableRes pokemonTypeOne: Int,
        @DrawableRes pokemonTypeTwo: Int?
    ) {
        Card(
            modifier = Modifier.padding(5.dp), shape = MaterialTheme.shapes.small,
            backgroundColor = backgroundColor
        ) {
            Column(
                Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = picture), contentDescription = "a pokemon",
                    alignment = Alignment.BottomEnd
                )
                Text(text = name, color = Color.White, fontSize = 35.sp)
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "N.º $pokedexNumber", color = Color.Black, fontSize = 12.sp
                )
                Row(modifier = Modifier.align(Alignment.Start)) {
                    Image( modifier = Modifier.size(45.dp) ,
                        painter = painterResource(id = pokemonTypeOne),
                        contentDescription = "pokemon type one"
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Pokedex_composeTheme {
            PokemonCard(
                "Bulbassaur",
                "001",
                R.drawable.ic_01,
                MaterialTheme.colors.secondaryVariant,
                R.drawable.ic_grass,
                null
            )
        }
    }
}