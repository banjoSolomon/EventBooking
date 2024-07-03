package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
