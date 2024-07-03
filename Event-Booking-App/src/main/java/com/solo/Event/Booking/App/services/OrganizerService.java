package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.*;
import com.solo.Event.Booking.App.dtos.response.*;

public interface OrganizerService {
    RegisterResponse register(RegisterRequest registerRequest);

    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    AddTicketResponse addTicketToEvent(AddTicketToEventRequest ticket);

    CreateGuestListResponse createGuestList(CreateGuestListRequest createGuestListRequest);

    CreateDiscountResponse createDiscount(CreateDiscountRequest createDiscountRequest);
}
