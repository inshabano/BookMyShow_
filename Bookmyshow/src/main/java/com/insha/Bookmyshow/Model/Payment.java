package com.insha.Bookmyshow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
@Entity

public class Payment extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private int amount;
    private String Referenceno;
    private Date timestamp;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
}
