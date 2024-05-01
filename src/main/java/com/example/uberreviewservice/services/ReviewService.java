package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository,
                         DriverRepository driverRepository){
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("**********************");
//        Review r =Review.builder()
//                        .content("amazing ride quality")
//                        .rating(3.0).build(); //code to create plain java object
//             Booking b = Booking.builder()
//                                .review(r)
//                                .endTime(new Date())
//                                .build();
////        reviewRepository.save(r);
//        bookingRepository.save(b);
//        System.out.println(r);
//      //this code executes sql query
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review : reviews){
//            System.out.println(review);
//        }
//
//        System.out.println(r.getRating());
//        reviewRepository.deleteById(2L);

//        Optional<Booking> b =bookingRepository.findById(2L);
//
//        if(b.isPresent()){
//            bookingRepository.delete(b.get());
//        }

//        Optional<Driver> driver = driverRepository.findById(1L);
//
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//
//            List<Booking> b = driver.get().getBookings();
//
//
////            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//                    for(Booking booking : b){
//                        System.out.println(booking.getId());
//                    }
//        }

//        Optional<Booking> b = bookingRepository.findById(1L);

//        CustomDriver driver = (CustomDriver) driverRepository.hqlFindByIdAndLicense(1L , "DL121212");
//        System.out.println(driver.getName());

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L,6L));

        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);

        for(Driver driver : drivers){
             List<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }

    }
}
