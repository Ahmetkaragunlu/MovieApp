package com.ahmetkaragunlu.movieapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ahmetkaragunlu.movieapp.model.Movie
import com.ahmetkaragunlu.movieapp.model.movieInfo
import com.ahmetkaragunlu.movieapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(modifier: Modifier=Modifier, navController: NavController,movieId :Int?) {


   val movieList= movieInfo.filter { movie->
    movie.id==movieId
   }

    Column(modifier.fillMaxSize()) {
        TopAppBar(title = {
            Row {
            Icon(imageVector = Icons.Default.ArrowBack,
        contentDescription = null,
        modifier =modifier.clickable { navController.popBackStack()}.size(36.dp))
            Spacer(modifier = Modifier.width(64.dp))
            Text(stringResource(R.string.movies), modifier = modifier.padding(top=4.dp))
            }
                             },
        colors = TopAppBarDefaults.topAppBarColors(titleContentColor = Color.Black),
        )
     MovieRow(movie = movieList.first())
        HorizontalDivider()
        Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxWidth()) {
            Text(stringResource(R.string.movie_images),
                fontWeight = FontWeight.Bold)

        }
        MovieLazyRow(movieList=movieList)

    }
}
@Composable
fun MovieLazyRow(movieList : List<Movie> ,modifier: Modifier=Modifier) {
    val contex= LocalContext.current
    movieList.forEach { movie->
        LazyRow{
            items(contex.resources.getStringArray(movie.images)) { imagesUrl->
                Card(modifier.size(160.dp).padding(4.dp)) {
                    AsyncImage(model = imagesUrl, contentDescription = null, contentScale = ContentScale.FillBounds)
                }
            }
        }
    }
}