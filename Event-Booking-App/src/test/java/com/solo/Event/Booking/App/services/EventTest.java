package com.solo.Event.Booking.App.services;

import com.solo.Event.Booking.App.dtos.requests.CreateEventRequest;
import com.solo.Event.Booking.App.dtos.requests.ViewAllEventRequest;
import com.solo.Event.Booking.App.dtos.response.CreateEventResponse;
import com.solo.Event.Booking.App.dtos.response.ViewAllResponse;
import com.solo.Event.Booking.App.models.Event;
import com.solo.Event.Booking.App.repository.EventRepository;
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
    @Autowired
    private EventRepository eventRepository;
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
    public void testToViewAllEventForAnOrganizer(){
        ViewAllEventRequest viewAllEventRequest = new ViewAllEventRequest();
        Event event1 = new Event();
        event1.setId(10L);
        event1.setName("Event1");
        event1.setDescription("Description1");
        event1.setStartTime(LocalTime.of(10, 0));
        event1.setLocation("Location 1");
        eventRepository.save(event1);

        Event event2 = new Event();
        event2.setId(90L);
        event2.setName("Event2");
        event2.setDescription("Description2");
        event2.setStartTime(LocalTime.of(12, 0));
        event2.setLocation("Location 2");
        eventRepository.save(event2);

        Event event3 = new Event();
        event3.setId(30L);
        event3.setName("Event3");
        event3.setDescription("Description3");
        event3.setStartTime(LocalTime.of(14, 0));
        event3.setLocation("Location 3");
        eventRepository.save(event3);

        ViewAllResponse viewAllResponse = eventService.viewAllEvent(viewAllEventRequest);
        assertNotNull(viewAllResponse);
        assertEquals(3, viewAllResponse.getEvents().size());


    }

    @Test
    public void testToReserveTicket() {


    }


}
