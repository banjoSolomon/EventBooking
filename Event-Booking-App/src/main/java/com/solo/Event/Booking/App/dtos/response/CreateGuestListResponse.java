package com.solo.Event.Booking.App.dtos.response;

import com.solo.Event.Booking.App.models.Guest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGuestListResponse {
    private List<Guest> guests;
    private String message;

}
