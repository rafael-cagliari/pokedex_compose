package com.example.pokedex_compose

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.pokedex_compose.model.Pokemon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private const val animationTime = 150

@Composable
fun PokemonCard(pokemon: Pokemon) {
    val navigator = LocalNavigator.currentOrThrow
    var wasClicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val scale by animateFloatAsState(targetValue = if (wasClicked) 0.8F else 1F, animationSpec = tween(
        durationMillis = animationTime,
        easing = FastOutSlowInEasing
    ))
    Box(contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .scale(scale)
                .padding(5.dp)
                .clickable {
                    coroutineScope.launch {
                        wasClicked = !wasClicked
                        delay(animationTime.toLong())
                        wasClicked = !wasClicked
                        delay(animationTime.toLong())
                        navigator.push(PokemonDetails(pokemon))
                    }
                },
            shape = if (wasClicked) MaterialTheme.shapes.small else MaterialTheme.shapes.large,
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