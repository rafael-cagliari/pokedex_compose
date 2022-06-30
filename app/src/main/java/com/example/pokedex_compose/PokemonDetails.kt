package com.example.pokedex_compose

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import com.example.pokedex_compose.model.Pokemon

data class PokemonDetails(val pokemon: Pokemon) : Screen {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val mp = MediaPlayer.create(context, pokemon.cry) //TO-DO use "remember"

        mp.start()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(pokemon.color)
        ) {
            Text(text = pokemon.name)
        }
    }
}
