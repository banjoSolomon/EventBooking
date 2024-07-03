package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
