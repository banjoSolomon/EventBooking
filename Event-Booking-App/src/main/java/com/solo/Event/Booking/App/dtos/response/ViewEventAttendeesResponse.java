package com.solo.Event.Booking.App.dtos.response;

import com.solo.Event.Booking.App.models.Attendees;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewEventAttendeesResponse {
    private List<Attendees> attendees;

}
