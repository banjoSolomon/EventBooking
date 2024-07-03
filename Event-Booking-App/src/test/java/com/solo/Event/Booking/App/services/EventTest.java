package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.ViewAllEventRequest;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.ViewAllResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/data.sql"})
public class EventTest {
    @Autowired
    private EventService eventService;
    @Test
    public void testToCreteEvent(){
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setName("Event1");
        createEventRequest.setId(6L);
        createEventRequest.setLocation("Location1");
        createEventRequest.setDescription("Description1");
        createEventRequest.setEventDate(LocalDateTime.now().plusDays(10));
        createEventRequest.setEventTime(LocalTime.of(12, 0));
        CreateEventResponse eventResponse = eventService.createEvent(createEventRequest);
        assertNotNull(eventResponse);
        assertEquals("Event created successfully", eventResponse.getMessage());

    }
    @Test
    public void testToViewAllTicketForAnOrganizer(){
        ViewAllEventRequest viewAllEventRequest = new ViewAllEventRequest();
        viewAllEventRequest.setOrganizerId(6L);
        ViewAllResponse viewAllResponse = eventService.viewAllEvent(viewAllEventRequest);
        assertNotNull(viewAllResponse);
        assertTrue(viewAllResponse.getEvents().size() > 0);


    }


}
