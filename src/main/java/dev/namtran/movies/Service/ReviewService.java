package dev.namtran.movies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.First;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import dev.namtran.movies.model.Movie;
import dev.namtran.movies.model.Review;
import dev.namtran.movies.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> getAllReviews(){
        // System.out.println(movieRepository.findAll().toString());
        return reviewRepository.findAll();
    }

    public Review createReview(String reviewBody, String imdbId){
        Review review=reviewRepository.insert(new Review(reviewBody));
        mongoTemplate.update(Movie.class)
                    .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("ReviewIds").value(review))
                    .first();
        return review;
    }
}
