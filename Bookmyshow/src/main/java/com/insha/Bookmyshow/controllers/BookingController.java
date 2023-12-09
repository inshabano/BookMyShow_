package com.insha.Bookmyshow.controllers;

import com.insha.Bookmyshow.DTOs.BookMovieRequestDto;
import com.insha.Bookmyshow.DTOs.BookMovieResponseDto;
import com.insha.Bookmyshow.DTOs.ResponseStatus;
import com.insha.Bookmyshow.Model.Booking;
import com.insha.Bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookService;
    @Autowired
    public BookingController(BookingService bookService) {
        this.bookService = bookService;
    }
     public BookMovieResponseDto bookMovie(BookMovieRequestDto request){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        Booking booking;
        try{
            booking = bookService.BookMovie(
                    request.getUserId(), request.getShowSeatIds(), request.getShowId()
            );
            bookMovieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setAmount(booking.getAmount());
        } catch (Exception e) {
            bookMovieResponseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return bookMovieResponseDto;
     }


}
