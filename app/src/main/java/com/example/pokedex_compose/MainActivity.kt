package com.example.pokedex_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.pokedex_compose.model.Pokemon
import com.example.pokedex_compose.ui.theme.GrassTypeGreen
import com.example.pokedex_compose.ui.theme.Pokedex_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigator(screen = RenderPokemonList(Pokemon.pokemonList))
        }
    }


    @OptIn(ExperimentalFoundationApi::class)

    data class RenderPokemonList(val pokemonList: List<Pokemon>) : Screen {

        @Composable
        override fun Content() {

            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(), cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(pokemonList) { pokemon -> PokemonCard(pokemon = pokemon) }
            }
        }

        @Composable
        fun PokemonCard(pokemon: Pokemon) {
            val navigator = LocalNavigator.currentOrThrow
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable { navigator.push(PokemonDetails(pokemon.name)) }, shape = MaterialTheme.shapes.medium,
                backgroundColor = pokemon.color
            ) {
                Column(
                    Modifier.padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = pokemon.image),
                        contentDescription = "a pokemon"
                    )
                    Text(
                        text = pokemon.name,
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.h5
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1F),
                            text = "N.º ${pokemon.number}",
                            color = MaterialTheme.colors.onBackground,
                            style = MaterialTheme.typography.caption
                        )
                        Image(
                            modifier = Modifier
                                .padding(start = 25.dp)
                                .size(45.dp),
                            painter = painterResource(id = pokemon.type),
                            contentDescription = "pokemon type one"
                        )
                    }
                }
            }
        }
    }

    data class PokemonDetails(val pokemonName:String): Screen{
        @Composable
        override fun Content() {
            Text(text = pokemonName)
        }

    }
}