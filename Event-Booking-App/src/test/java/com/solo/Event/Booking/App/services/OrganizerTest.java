package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.*;
import com.solo.Event.Booking.App.dtos.response.*;

import com.solo.Event.Booking.App.models.Attendees;
import com.solo.Event.Booking.App.models.Event;
import com.solo.Event.Booking.App.repository.AttendeesRepository;
import com.solo.Event.Booking.App.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalTime;


import static com.solo.Event.Booking.App.models.Category.VIP;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/data.sql"})
public class OrganizerTest {
    @Autowired
    OrganizerService organizationService;
    @Autowired
    AttendeesRepository attendeesRepository;
    @Autowired
    EventRepository eventRepository;

    @Test
    public void testOrganizerCanRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        RegisterResponse registerResponse = organizationService.register(registerRequest);
        assertNotNull(registerResponse);
        assertTrue(registerResponse.getMessage().contains("success"));

    }

    @Test
    public void testToAddTicketToEvent() {
        AddTicketToEventRequest ticket = new AddTicketToEventRequest();
        ticket.setId(5L);
        ticket.setEventId(10L);
        ticket.setCategory(VIP);
        ticket.setPrice(BigDecimal.valueOf(2000.0));
        AddTicketResponse ticketResponse = organizationService.addTicketToEvent(ticket);
        assertNotNull(ticketResponse);
        assertEquals(ticket.getCategory(), ticketResponse.getCategory());
        assertEquals(ticket.getPrice(), ticketResponse.getPrice());


    }

    @Test
    public void testToCreateGuestList(){
        CreateGuestListRequest createGuestListRequest = new CreateGuestListRequest();
        createGuestListRequest.setEventId(10L);
        createGuestListRequest.setGuestName("Guest1, Guest2, Guest3");
        CreateGuestListResponse createGuestListResponse = organizationService.createGuestList(createGuestListRequest);
        assertNotNull(createGuestListResponse);
        assertEquals("Guest list created successfully", createGuestListResponse.getMessage());
        assertEquals(3, createGuestListResponse.getGuests().size());
    }

    @Test
    public void testToCreateDiscountForTicket(){
        CreateDiscountRequest createDiscountRequest = new CreateDiscountRequest();
        createDiscountRequest.setEventId(10L);
        createDiscountRequest.setDiscountPercentage(BigDecimal.valueOf(20.1));
        CreateDiscountResponse createDiscountResponse = organizationService.createDiscount(createDiscountRequest);
        assertNotNull(createDiscountResponse);
        assertEquals("Discount created successfully", createDiscountResponse.getMessage());

    }

    @Test
    public void testToViewEventAttendees(){
        ViewEventAttendeesRequest viewEventAttendeesRequest = new ViewEventAttendeesRequest();
        viewEventAttendeesRequest.setEventId(10L);
        Attendees attendee3 = createEvent();
        attendeesRepository.save(attendee3);
        ViewEventAttendeesResponse viewEventAttendeesResponse = organizationService.viewEventAttendees(viewEventAttendeesRequest);
        assertNotNull(viewEventAttendeesResponse);
        assertEquals(3, viewEventAttendeesResponse.getAttendees().size());
    }

    private Attendees createEvent() {
        Event event = new Event();
        event.setId(10L);
        event.setName("Event 1");
        event.setDescription("Description 1");
        event.setStartTime(LocalTime.of(10, 0));
        event.setLocation("Location 1");
        eventRepository.save(event);
        Attendees attendee1 = new Attendees();
        attendee1.setEvent(event);
        attendee1.setName("Attendee 1");
        attendeesRepository.save(attendee1);
        Attendees attendee2 = new Attendees();
        attendee2.setEvent(event);
        attendee2.setName("Attendee 2");
        attendeesRepository.save(attendee2);
        Attendees attendee3 = new Attendees();
        attendee3.setEvent(event);
        attendee3.setName("Attendee 3");
        return attendee3;
    }


}


