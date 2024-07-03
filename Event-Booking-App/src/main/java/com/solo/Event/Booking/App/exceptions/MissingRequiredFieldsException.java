package com.solo.Event.Booking.App.exceptions;

public class MissingRequiredFieldsException extends RuntimeException{
    public MissingRequiredFieldsException(String message) {
        super(message);
    }
}
