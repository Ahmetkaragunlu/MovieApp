package com.ahmetkaragunlu.movieapp.model

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import com.ahmetkaragunlu.movieapp.R

data class Movie(
    @StringRes val id : Int,
    @StringRes val title: Int,
    @StringRes val year : Int,
    @StringRes val genre: Int,
    @StringRes val director: Int,
    @StringRes val actors: Int,
    @StringRes val plot: Int,
    @StringRes val poster: Int,
     @ArrayRes val images: Int,
    @StringRes val rating: Int

)



val movieInfo= listOf(
    Movie(
        id = R.string.avatar_id,
        title = R.string.avatar_title,
        year = R.string.avatar_year,
        genre = R.string.avatar_genre,
        director = R.string.avatar_director,
        actors = R.string.avatar_actors,
        plot = R.string.avatar_plot,
        poster =R.string.avatar_poster,
        images =R.array.avatar_images,
        rating =R.string.avatar_rating
    ),
    Movie(
        id = R.string.id_300,
        title = R.string.title_300,
        year = R.string.year_300,
        genre = R.string.genre_300,
        director = R.string.director_300,
        actors = R.string.actors_300,
        plot = R.string.plot_300,
        poster = R.string.poster_300,
        images = R.array.images_300,
        rating = R.string.rating_300
    ),
    Movie(
        id = R.string.avengers_id,
        title = R.string.avengers_title,
        year = R.string.avengers_year,
        genre = R.string.avengers_genre,
        director = R.string.avengers_director,
        actors = R.string.avengers_actors,
        plot = R.string.avengers_plot,
        poster = R.string.avengers_poster,
        images = R.array.avengers_images,
        rating = R.string.avengers_rating
    ),
    Movie(
        id = R.string.wall_street_id,
        title = R.string.wall_street_title,
        year = R.string.wall_street_year,
        genre = R.string.wall_street_genre,
        director = R.string.wall_street_director,
        actors = R.string.wall_street_actors,
        plot = R.string.wall_street_plot,
        poster = R.string.wall_street_poster,
        images = R.array.wall_street_images,
        rating = R.string.wall_street_rating
    ),
    Movie(
    id = R.string.interstellar_id,
    title = R.string.interstellar_title,
    year = R.string.interstellar_year,
    genre = R.string.interstellar_genre,
    director = R.string.interstellar_director,
    actors = R.string.interstellar_actors,
    plot =R.string.interstellar_plot,
    poster = R.string.interstellar_poster,
    images = R.array.interstellar_images,
    rating = R.string.rating_300
    ),
    Movie(
        id =R.string.game_of_thrones_id,
        title =R.string.game_of_thrones_title,
        year =R.string.game_of_thrones_year,
        genre =R.string.game_of_thrones_genre,
        director = R.string.game_of_thrones_director,
        actors =R.string.game_of_thrones_actors,
        plot =R.string.game_of_thrones_plot,
        poster = R.string.game_of_thrones_poster,
        images = R.array.game_of_thrones_images,
        rating = R.string.game_of_thrones_rating
    ),
    Movie(
    id =R.string.vikings_id,
    title =R.string.vikings_title,
    year =R.string.vikings_year,
    genre =R.string.vikings_genre,
    director =R.string.vikings_director,
    actors = R.string.vikings_actors,
    plot = R.string.vikings_plot,
    poster = R.string.vikings_poster,
    images = R.array.vikings_images,
    rating = R.string.vikings_rating
    ),
    Movie(
        id = R.string.breaking_bad_id,
        title = R.string.breaking_bad_title,
        year = R.string.breaking_bad_year,
        genre = R.string.breaking_bad_genre,
        director = R.string.breaking_bad_director,
        actors = R.string.breaking_bad_actors,
        plot= R.string.breaking_bad_plot,
        poster = R.string.breaking_bad_poster,
        images =R.array.breaking_bad_images,
        rating = R.string.breaking_bad_rating
    ),
    Movie(
        id = R.string.narcos_id,
        title = R.string.narcos_title,
        year = R.string.narcos_year,
        genre = R.string.narcos_genre,
        director = R.string.narcos_director,
        actors = R.string.narcos_actors,
        plot = R.string.narcos_plot,
        poster = R.string.narcos_poster,
        images = R.array.narcos_images,
        rating = R.string.narcos_rating
    )
)

