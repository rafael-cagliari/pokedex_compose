package com.example.pokedex_compose.model

import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.pokedex_compose.R
import com.example.pokedex_compose.ui.theme.FireTypeRed
import com.example.pokedex_compose.ui.theme.GrassTypeGreen
import com.example.pokedex_compose.ui.theme.Purple200
import com.example.pokedex_compose.ui.theme.WaterTypeBlue

data class Pokemon(
    val name: String,
    val number: String,
    val color: Color,
    @DrawableRes val image: Int,
    @DrawableRes val type: Int
) {
    companion object {
        val pokemonList:List<Pokemon> =
            listOf(
                Pokemon("Bulsabassaur", "001", GrassTypeGreen, R.drawable.ic_01, R.drawable.ic_grass),
                Pokemon("Ivysaur", "002", GrassTypeGreen, R.drawable.ic_02, R.drawable.ic_grass),
                Pokemon("Venussaur", "003", GrassTypeGreen, R.drawable.ic_03, R.drawable.ic_grass),
                Pokemon("Charmander", "004", FireTypeRed, R.drawable.ic_04, R.drawable.ic_fire),
                Pokemon("Charmeleon", "005", FireTypeRed, R.drawable.ic_05, R.drawable.ic_fire),
                Pokemon("Charizard", "006", FireTypeRed, R.drawable.ic_06, R.drawable.ic_fire),
                Pokemon("Squirtle", "007", WaterTypeBlue, R.drawable.ic_07, R.drawable.ic_water),
                Pokemon("Wartortle", "008", WaterTypeBlue, R.drawable.ic_08, R.drawable.ic_water),
                Pokemon("Blastoise", "009", WaterTypeBlue, R.drawable.ic_09, R.drawable.ic_water)
            )
    }
}