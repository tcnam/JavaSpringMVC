package dev.namtran.movies.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.namtran.movies.service.MovieService;
import dev.namtran.movies.model.Movie;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieControler {

    @Autowired
    private MovieService movieService;

    @GetMapping(path={"/all"})
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    // @GetMapping(path={"/{imdbId}"})
    // public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
    //     return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatus.OK);
    // }

    @PostMapping(path={"/addMovie"})
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.saveMovie(movie),HttpStatus.OK);
    }
}
