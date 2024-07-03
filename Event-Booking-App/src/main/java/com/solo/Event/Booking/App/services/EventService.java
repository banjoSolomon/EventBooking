package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.ViewAllEventRequest;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.ViewAllResponse;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    ViewAllResponse viewAllEvent(ViewAllEventRequest viewAllEventRequest);

}
