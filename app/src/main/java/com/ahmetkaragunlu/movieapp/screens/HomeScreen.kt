package com.ahmetkaragunlu.movieapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ahmetkaragunlu.movieapp.model.Movie
import com.ahmetkaragunlu.movieapp.model.movieInfo
import com.ahmetkaragunlu.movieapp.R
import com.ahmetkaragunlu.movieapp.navigation.MovieScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Magenta, titleContentColor = Color.Blue),
            title = { Text(stringResource(R.string.movies)) }) }
    ) { paddingValues->
        LazyColumn(modifier = modifier.padding(paddingValues)) {
            items(movieInfo) { movies->
                Card(modifier = modifier.fillMaxWidth().padding(8.dp)
                    .shadow(elevation = 8.dp)
                    .clickable { navController.navigate("${MovieScreen.DETAILSCREEN.route}/${movies.id}") },
                    shape = RoundedCornerShape(corner = CornerSize(12.dp)),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(width = 1.dp, color = Color.LightGray),
                ) {
                    MovieRow(movie = movies)
                }
            }
        }
    }
}

@Composable
fun MovieRow(modifier: Modifier = Modifier, movie: Movie) {
    val context = LocalContext.current
    val images = context.resources.getStringArray(movie.images)[0]
    var expanded by remember {
        mutableStateOf(false)
    }

    Row(modifier = modifier.padding(8.dp)) {
        Surface(
            modifier = modifier.size(120.dp).padding(4.dp),
            shape = RectangleShape,
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            AsyncImage(
                modifier = modifier.clip(shape = CircleShape),
                contentScale = ContentScale.Crop,
                model = images,
                contentDescription = null
            )
        }
        Column(modifier.padding(start = 8.dp)) {
            Text(
                stringResource(id = movie.title),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                modifier = modifier.padding(top = 8.dp)
            )
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                    append("Director: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(stringResource(id = movie.director))
                }
            })
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                    append("Released: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(stringResource(movie.year))
                }
            })

            AnimatedVisibility(visible = expanded) {
                Column {
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                            append("Plot: ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(movie.plot))
                        }
                    })
                    HorizontalDivider()
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                            append("Actors: ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(movie.actors))
                        }
                    })
                    HorizontalDivider()
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                            append("Rating: ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(movie.rating))
                        }
                    })
                }
            }

            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = modifier.clickable { expanded = !expanded }
            )
        }
    }
}
