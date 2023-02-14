package dev.namtran.movies.service;

import java.util.List;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.namtran.movies.model.Movie;
import dev.namtran.movies.repository.MovieRepository;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    // public Optional<Movie> singleMovie(String imdbId){
    //     return movieRepository.findMovieByImbdId(imdbId);
    // }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
