package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.AddTicketToEventRequest;
import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.CreateGuestListRequest;
import com.solo.Event.Booking.App.dtos.requests.RegisterRequest;
import com.solo.Event.Booking.App.dtos.response.AddTicketResponse;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.CreateGuestListResponse;
import com.solo.Event.Booking.App.dtos.response.RegisterResponse;

public interface OrganizerService {
    RegisterResponse register(RegisterRequest registerRequest);

    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    AddTicketResponse addTicketToEvent(AddTicketToEventRequest ticket);

    CreateGuestListResponse createGuestList(CreateGuestListRequest createGuestListRequest);

}
