package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.AddTicketToEventRequest;
import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.RegisterRequest;
import com.solo.Event.Booking.App.dtos.response.AddTicketResponse;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.RegisterResponse;
import com.solo.Event.Booking.App.models.Event;
import com.solo.Event.Booking.App.models.Organizer;
import com.solo.Event.Booking.App.models.Ticket;
import com.solo.Event.Booking.App.repository.EventRepository;
import com.solo.Event.Booking.App.repository.OrganizerRepository;
import com.solo.Event.Booking.App.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizerImpl implements OrganizerService {
    private final ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;

    public OrganizerImpl(ModelMapper modelMapper, OrganizerRepository organizerRepository, EventRepository eventRepository, TicketRepository ticketRepository) {
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Organizer organizer = modelMapper.map(registerRequest, Organizer.class);
        organizer = organizerRepository.save(organizer);
        var response = modelMapper.map(registerRequest, RegisterResponse.class);
        response.setMessage("user registered successfully");
        return response;
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {

        return null;

    }

    @Override
    public AddTicketResponse addTicketToEvent(AddTicketToEventRequest ticket) {
        Event event = eventRepository.findById(ticket.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));
        Ticket tickets = new Ticket();
        tickets.setCategory(ticket.getCategory());
        tickets.setPrice(tickets.getPrice());
        tickets.setEvent(event);

        tickets = ticketRepository.save(tickets);

        return modelMapper.map(ticket, AddTicketResponse.class);
    }
}