package com.solo.Event.Booking.App.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGuestListRequest {
    private Long eventId;
    private Long guestId;
    private String guestName;

}
