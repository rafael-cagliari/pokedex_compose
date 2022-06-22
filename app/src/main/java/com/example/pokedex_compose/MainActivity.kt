package com.example.pokedex_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex_compose.model.Pokemon
import com.example.pokedex_compose.ui.theme.Pokedex_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex_composeTheme {
                PokemonList(pokemonList = Pokemon.pokemonList)
            }
        }
    }

    @Composable
    fun PokemonCard(pokemon: Pokemon) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .size(200.dp), shape = MaterialTheme.shapes.medium,
            backgroundColor = pokemon.color
        ) {
            Column(
                Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = pokemon.image), contentDescription = "a pokemon",
                    alignment = Alignment.BottomEnd
                )
                Text(
                    text = pokemon.name,
                    color = Color.White,
                    fontSize = 27.sp,
                )
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "N.º ${pokemon.number}",
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(modifier = Modifier.align(Alignment.Start)) {
                    Image(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(id = pokemon.type),
                        contentDescription = "pokemon type one"
                    )
                }
            }
        }
    }

    @Composable
    fun PokemonList(pokemonList: List<Pokemon>) {
        LazyColumn {
            items(pokemonList) { pokemon -> PokemonCard(pokemon = pokemon) }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Pokedex_composeTheme {
            PokemonList(pokemonList = Pokemon.pokemonList)
        }
    }
}