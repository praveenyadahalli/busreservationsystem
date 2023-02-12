package com.bus.reservationsystem.service;

import com.bus.reservationsystem.entity.BookingEntity;
import com.bus.reservationsystem.representation.request.BookingRequest;
import com.bus.reservationsystem.representation.response.BookingResponse;

import java.util.List;

/**
 * Booking Service
 * <p>
 * Booking Service has 4 methods including query method
 */
public interface BookingService {
    public BookingResponse newBooking(BookingRequest bookingRequest, Long busId);

    public BookingResponse bookingDetails(Long bookId);

    public List<BookingEntity> adminBookingDetails(Long frn_busId);

    public BookingResponse cancelBooking(long bookId);
}
