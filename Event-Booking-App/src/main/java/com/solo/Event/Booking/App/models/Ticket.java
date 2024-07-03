package com.solo.Event.Booking.App.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Table(name = "ticket")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal price;
    @ManyToOne
    private Event event;
    @Enumerated(value = STRING)
    private Category category;
}
