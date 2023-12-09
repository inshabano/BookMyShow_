package com.insha.Bookmyshow.services;

import com.insha.Bookmyshow.Model.*;
import com.insha.Bookmyshow.Repositories.BookingRepository;
import com.insha.Bookmyshow.Repositories.ShowRepository;
import com.insha.Bookmyshow.Repositories.ShowSeatRepository;
import com.insha.Bookmyshow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {
    private  UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private AmountCalculatorService amountCalculatorService;
    private BookingRepository bookingRepository;
     @Autowired
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          AmountCalculatorService amountCalculatorService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.amountCalculatorService = amountCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation= Isolation.SERIALIZABLE)             // Transaction isolation
    public Booking BookMovie(Long UserId, List<Long> seatIds, Long showId){//Whole BookMovie is taken as one transaction
       ;
        //from the frontend we get the ids
        //from user we got the user id, show id and the seat id they want to book.
        //Now check the availability of the seats and proceed with the booking
        // if it is available or if it is not error is returned

        //1)Get the user with the user ID
        Optional<User> userOptional =userRepository.findById(UserId);      //avoiding null pointer exceptions
        if(userOptional.isEmpty()){
            throw new RuntimeException("Require user");      //Ideally there would be user
        }
        User bookedBy = userOptional.get();

        //2)Get the show with show id
        Optional<Show> showOptional =showRepository.findById(showId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("SHOW NOT FOUND");
        }
        Show bookedShow =showOptional.get();

        //3)Get seats with seat id
        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);

        //4)Check if the seats are available
        for (ShowSeat showSeat :showSeats){       // Epoch time - starting point used to calculate the number of seconds elapsed.
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED))
            && Duration.between(showSeat.getBlockedAt().toInstant() , new Date().toInstant()).toMinutes() >15)){
                throw new RuntimeException("SEATS NOT AVAILABLE");
            }
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();

        //5)Mark the seat status as locked
        for(ShowSeat showSeat : showSeats ){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        Booking booking = new Booking() ;
        booking.setBookingStatus(BookingStatus.In_PROGRESS);
        booking.setShowseats(savedShowSeats);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
        booking.setAmount(amountCalculatorService.calculateAmount(savedShowSeats, bookedShow));

        //6)Save the booking
        bookingRepository.save(booking);
        return booking;


    }
}
