package com.insha.Bookmyshow.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity


public class Booking extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<ShowSeat> showseats;
    private int amount;
    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;
}
