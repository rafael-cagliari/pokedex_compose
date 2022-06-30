package com.example.pokedex_compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.pokedex_compose.model.Pokemon

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
}