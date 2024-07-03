package com.solo.Event.Booking.App.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attendees {
    @Id
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    private Event event;
}
