package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.exceptions.MissingRequiredFieldsException;
import com.solo.Event.Booking.App.models.Event;
import com.solo.Event.Booking.App.models.Organizer;
import com.solo.Event.Booking.App.repository.EventRepository;
import com.solo.Event.Booking.App.repository.OrganizerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements  EventService{
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;

    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper, OrganizerRepository organizerRepository) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        validateCredentials(createEventRequest);
        Long organizerId = createEventRequest.getId();
        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid organizer ID"));
        Event event = modelMapper.map(createEventRequest, Event.class);
        event.setOrganizer(organizer);
        event = eventRepository.save(event);
        CreateEventResponse response = new CreateEventResponse();
        response.setMessage("Event created successfully");
        response.setId(event.getId());

        return response;

    }

    private static void validateCredentials(CreateEventRequest createEventRequest) {
        if (createEventRequest.getName() == null || createEventRequest.getEventDate() == null ||
                createEventRequest.getEventTime() == null || createEventRequest.getLocation() == null) {
            throw new MissingRequiredFieldsException("Missing required fields");
        }
    }
}