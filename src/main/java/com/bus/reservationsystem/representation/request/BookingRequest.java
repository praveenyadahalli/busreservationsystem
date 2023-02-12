package com.bus.reservationsystem.representation.request;

import lombok.Data;

/**
 * Booking Request
 * <p>
 * This is the booking request contains two fields
 */
@Data
public class BookingRequest {
    /**
     * Field for username
     */
    String userName;

    /**
     * SeatsBooked field
     */
    Integer seatsBooked;

}
