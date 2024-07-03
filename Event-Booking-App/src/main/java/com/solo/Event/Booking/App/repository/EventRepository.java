package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
