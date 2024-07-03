package com.solo.Event.Booking.App.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class CreateEventRequest {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private LocalTime eventTime;
    private String location;

}
