package com.solo.Event.Booking.App.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;

@Getter
@Setter
@Entity
@Table(name = "organizer")
public class Organizer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Setter(AccessLevel.NONE)
    private LocalDateTime dateRegistered;
    @OneToMany
    private List<Event> events;

    @PrePersist
    private void dateRegistered(){
        dateRegistered = now();
    }


}
