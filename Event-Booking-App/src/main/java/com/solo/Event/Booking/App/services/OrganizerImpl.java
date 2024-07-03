package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.AddTicketToEventRequest;
import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.CreateGuestListRequest;
import com.solo.Event.Booking.App.dtos.requests.RegisterRequest;
import com.solo.Event.Booking.App.dtos.response.AddTicketResponse;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.CreateGuestListResponse;
import com.solo.Event.Booking.App.dtos.response.RegisterResponse;
import com.solo.Event.Booking.App.models.Event;
import com.solo.Event.Booking.App.models.Guest;
import com.solo.Event.Booking.App.models.Organizer;
import com.solo.Event.Booking.App.models.Ticket;
import com.solo.Event.Booking.App.repository.EventRepository;
import com.solo.Event.Booking.App.repository.GuestRepository;
import com.solo.Event.Booking.App.repository.OrganizerRepository;
import com.solo.Event.Booking.App.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizerImpl implements OrganizerService {
    private final ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final GuestRepository guestRepository;

    public OrganizerImpl(ModelMapper modelMapper, OrganizerRepository organizerRepository, EventRepository eventRepository, TicketRepository ticketRepository, GuestRepository guestRepository) {
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
        this.guestRepository = guestRepository;
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

    @Override
    public CreateGuestListResponse createGuestList(CreateGuestListRequest createGuestListRequest) {
        Event event = eventRepository.findById(createGuestListRequest.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));
        String[] guestNamesArray = createGuestListRequest.getGuestName().split(",\\s*");
        List<Guest> guests = Arrays.stream(guestNamesArray)
                .map(name -> {
                    Guest guest = new Guest();
                    guest.setName(name);
                    guest.setEvent(event);
                    return guest;
                }).collect(Collectors.toList());
        guestRepository.saveAll(guests);
        CreateGuestListResponse response = new CreateGuestListResponse();
        response.setMessage("Guest list created successfully");
        return response;

    }
}