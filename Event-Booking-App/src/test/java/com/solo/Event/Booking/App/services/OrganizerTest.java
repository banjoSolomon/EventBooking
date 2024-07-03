package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.AddTicketToEventRequest;
import com.solo.Event.Booking.App.dtos.requests.RegisterRequest;
import com.solo.Event.Booking.App.dtos.requests.ViewAllEventRequest;
import com.solo.Event.Booking.App.dtos.response.AddTicketResponse;
import com.solo.Event.Booking.App.dtos.response.RegisterResponse;

import com.solo.Event.Booking.App.dtos.response.ViewAllResponse;
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


}


