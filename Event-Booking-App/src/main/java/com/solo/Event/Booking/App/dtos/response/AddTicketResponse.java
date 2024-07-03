package com.solo.Event.Booking.App.dtos.response;

import com.solo.Event.Booking.App.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class AddTicketResponse {
    private Long id;
    private Category category;
    private BigDecimal price;

}
