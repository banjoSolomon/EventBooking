package com.solo.Event.Booking.App.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateDiscountRequest {
    private Long eventId;
    private BigDecimal discountPercentage;


}
