package com.bus.reservationsystem.representation.request;

import lombok.Data;

import java.util.Date;

/**
 * Bus Request
 * <p>
 * This is the bus request contains 6 fields
 */
@Data
public class BusRequest {

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
     * startLocation field
     */
    String startLocation;

    /**
     * endLocation field
     */
    String endLocation;

    /**
     * noOfSeats field
     */
    Integer noOfSeats;
}
