package dev.namtran.movies.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.List;

import dev.namtran.movies.Service.ReviewService;
import dev.namtran.movies.model.Review;



@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewControler {
    @Autowired
    private ReviewService reviewService;

    @GetMapping(path={"all"})
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<List<Review>>(reviewService.getAllReviews(),HttpStatus.OK);
    }

    @PostMapping(path={"addReview"})
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")),HttpStatus.CREATED);
    }
}
