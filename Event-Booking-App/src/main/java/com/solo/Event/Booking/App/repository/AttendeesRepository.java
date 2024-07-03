package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendeesRepository extends JpaRepository<Attendees, Long> {

    @Query("SELECT a FROM Attendees a WHERE a.event.id = :eventId")
    List<Attendees> findByEventId(long l);
}
