package com.bus.reservationsystem.representation.response;

import lombok.Data;

import java.util.Date;

/**
 * Booking Response
 * <p>
 * This is booking response
 */
@Data
public class BookingResponse {

    /**
     * bookId field
     */
    Long bookId;

    /**
     * userName field
     */
    String userName;

    /**
     * seatsBooked field
     */
    Integer seatsBooked;

    /**
     * busName field
     */
    String busName;

    /**
     * date field
     */
    Date date;

    /**
     * busType field
     */
    String busType;

    /**
     * start location field
     */
    String startLocation;

    /**
     * end location field
     */
    String endLocation;
}
