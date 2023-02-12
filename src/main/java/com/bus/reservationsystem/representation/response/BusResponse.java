package com.bus.reservationsystem.representation.response;

import lombok.Data;

import java.util.Date;

/**
 * Bus Response
 * <p>
 * This is busResponse
 */
@Data
public class BusResponse {

    /**
     * busId field
     */
    Long busId;

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
     * start Location field
     */
    String startLocation;

    /**
     * end Location field
     */
    String endLocation;

    /**
     * No of seats field
     */
    Integer noOfSeats;
}
