package com.solo.Event.Booking.App.dtos.requests;

import com.solo.Event.Booking.App.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class AddTicketToEventRequest {
    private Long id;
    private Long eventId;
    private Category category;
    private BigDecimal price;




}
