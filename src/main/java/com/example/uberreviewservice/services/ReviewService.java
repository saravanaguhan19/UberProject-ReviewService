package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**********************");
        Review r =Review.builder()
                        .content("best ride quality")

                        .rating(3.0).build(); //code to create plain java object
        System.out.println(r);
        reviewRepository.save(r); //this code executes sql query
        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(review);
        }

        System.out.println(r.getRating());
//        reviewRepository.deleteById(2L);

    }
}
