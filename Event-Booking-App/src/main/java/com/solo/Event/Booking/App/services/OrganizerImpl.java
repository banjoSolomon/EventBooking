package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.*;
import com.solo.Event.Booking.App.dtos.response.*;
import com.solo.Event.Booking.App.exceptions.EventNotFoundException;
import com.solo.Event.Booking.App.models.*;
import com.solo.Event.Booking.App.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizerImpl implements OrganizerService {
    private final ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final GuestRepository guestRepository;
    private final AttendeesRepository attendeesRepository;

    public OrganizerImpl(ModelMapper modelMapper, OrganizerRepository organizerRepository, EventRepository eventRepository, TicketRepository ticketRepository, GuestRepository guestRepository, AttendeesRepository attendeesRepository) {
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
        this.guestRepository = guestRepository;
        this.attendeesRepository = attendeesRepository;
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
                .orElseThrow(() -> new EventNotFoundException("Event not found"));
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
                .orElseThrow(() -> new EventNotFoundException("Event not found"));
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

    @Override
    public CreateDiscountResponse createDiscount(CreateDiscountRequest createDiscountRequest) {
        Event event = eventRepository.findById(createDiscountRequest.getEventId())
                .orElseThrow(() -> new EventNotFoundException("Event not found"));
        event.setDiscountPercentage(createDiscountRequest.getDiscountPercentage());
        eventRepository.save(event);
        CreateDiscountResponse response = new CreateDiscountResponse();
        response.setMessage("Discount created successfully");
        return response;
    }

    @Override
    public ViewEventAttendeesResponse viewEventAttendees(ViewEventAttendeesRequest viewEventAttendeesRequest) {
        List<Attendees> attendees = attendeesRepository.findByEventId(viewEventAttendeesRequest.getEventId());
        ViewEventAttendeesResponse response = new ViewEventAttendeesResponse();
        response.setAttendees(attendees);

        return response;

    }


}