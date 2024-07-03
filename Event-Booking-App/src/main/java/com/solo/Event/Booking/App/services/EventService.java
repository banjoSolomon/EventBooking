package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

}
