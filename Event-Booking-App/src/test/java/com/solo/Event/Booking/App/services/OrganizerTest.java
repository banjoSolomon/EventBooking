package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.*;
import com.solo.Event.Booking.App.dtos.response.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;


import static com.solo.Event.Booking.App.models.Category.VIP;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/data.sql"})
public class OrganizerTest {
    @Autowired
    OrganizerService organizationService;

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
        ViewEventAttendeesResponse viewEventAttendeesResponse = organizationService.viewEventAttendees(viewEventAttendeesRequest);
        assertNotNull(viewEventAttendeesResponse);
        assertEquals(3, viewEventAttendeesResponse.getAttendees().size());
    }


}


