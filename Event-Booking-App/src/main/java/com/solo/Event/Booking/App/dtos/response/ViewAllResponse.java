package com.solo.Event.Booking.App.dtos.response;

import com.solo.Event.Booking.App.models.EventForUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ViewAllResponse {
    private List<EventForUser> users;
}
