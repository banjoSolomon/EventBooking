package com.solo.Event.Booking.App.repository;

import com.solo.Event.Booking.App.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
