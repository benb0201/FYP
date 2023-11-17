package com.example.travelpal.controller;

import com.example.travelpal.models.Review;
import com.example.travelpal.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/review")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @PostMapping
    public void registerReview(@RequestBody Review review){
        reviewService.addNewReview(review);
    }

    @DeleteMapping(path = "{reviewid}")
    public void deleteReview(@PathVariable Long reviewId){
        reviewService.deleteReview(reviewId);
    }

    @PutMapping(path = "{reviewid}")
    public void updateReview(@PathVariable Long reviewId, @RequestBody Review review){
        reviewService.updateReview(review, reviewId);
    }
}
