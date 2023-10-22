package com.example.travelpal.service;

import com.example.travelpal.models.Review;
import com.example.travelpal.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    public void addNewReview(Review review){
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId){
        reviewRepository.deleteById(reviewId);
    }

    public void updateReview(Review review, Long reviewId){
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isEmpty()) {
            throw new EntityNotFoundException("Transport with ID " + reviewId + " not found");
        }

        // Get the existing review from the Optional
        Review existingReview = reviewOptional.get();

        // Update the attributes of the existing review with the values from the new review
        existingReview.setTitle(review.getTitle());
        existingReview.setContent(review.getContent());
        existingReview.setRating(review.getRating());
        existingReview.setDestination(review.getDestination());
        existingReview.setActivity(review.getActivity());


        // Save the updated review back to the repository
        reviewRepository.save(existingReview);
    }
}
