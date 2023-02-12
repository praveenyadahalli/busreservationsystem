package com.bus.reservationsystem.controller;

import com.bus.reservationsystem.entity.BookingEntity;
import com.bus.reservationsystem.representation.request.BookingRequest;
import com.bus.reservationsystem.representation.response.BookingResponse;
import com.bus.reservationsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bus Booking Controller
 * <p>
 * Rest Api's for bus bookings
 */
@RestController
@RequestMapping("/book")
public class BookingController {
    @Autowired
    BookingService bookingService;

    /**
     * Get booking details by passing bookid
     *
     * @param bookId
     * @return booking details of bookId
     */
    @GetMapping("/{bookId}")
    public ResponseEntity<BookingResponse> bookingDetails(@PathVariable String bookId) {
        BookingResponse bookingResponse = bookingService.bookingDetails(Long.parseLong(bookId));
        return new ResponseEntity<BookingResponse>(bookingResponse, HttpStatus.OK);
    }

    /**
     * Get list of user registered for particular bus
     *
     * @param frn_busId
     * @return booked user details
     */
    @GetMapping("/admin/{frn_busId}")
    public ResponseEntity<List<BookingEntity>> adminBookingDetails(@PathVariable Long frn_busId) {
        return new ResponseEntity<>(bookingService.adminBookingDetails(frn_busId), HttpStatus.OK);
    }

    /**
     * Book a new bus
     *
     * @param bookingEntity
     * @param busId
     * @return new booking
     */
    @PostMapping("/{busId}")
    public ResponseEntity<BookingResponse> newBooking(@RequestBody BookingRequest bookingEntity, @PathVariable Long busId) {
        BookingResponse bookingResponse = bookingService.newBooking(bookingEntity, busId);
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    /**
     * Cancel the booking by passing the bookId
     *
     * @param bookId
     * @return null
     */
    @DeleteMapping("/{bookId}")
    public ResponseEntity<BookingResponse> cancelBooking(@PathVariable String bookId) {
        BookingResponse bookingResponse = bookingService.cancelBooking(Long.parseLong(bookId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
