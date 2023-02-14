package dev.namtran.movies.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import dev.namtran.movies.model.Movie;

import java.util.Optional;

import org.bson.types.ObjectId;


@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
    // Optional<Movie> findMovieByImbdId(String imdbId);
}
