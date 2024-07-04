package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AttendeesRepository extends JpaRepository<Attendees, Long> {


    List<Attendees> findByEventId(Long eventId);

}
