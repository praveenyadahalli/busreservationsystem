package com.bus.reservationsystem.service;

import com.bus.reservationsystem.entity.BookingEntity;
import com.bus.reservationsystem.repository.BookingRepository;
import com.bus.reservationsystem.representation.request.BookingRequest;
import com.bus.reservationsystem.representation.response.BookingResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

/**
 * Booking Service Implementation
 * <p>
 * all the methods present in the booking Service will be implemented here
 */
@NoArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    /**
     * Auto Wiring BookingRepository to access it
     */
    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Auto wiring BusService to access busService methods
     */
    @Autowired
    private BusService busService;

    /**
     * Method for new Bus Booking
     *
     * @param bookingRequest
     * @param busId
     * @return new booking
     */
    @Override
    public BookingResponse newBooking(BookingRequest bookingRequest, Long busId) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBusEntity(busService.findBusById(busId.toString()));
        bookingEntity.setUserName(bookingRequest.getUserName());
        bookingEntity.setSeatsBooked(bookingRequest.getSeatsBooked());
        bookingRepository.save(bookingEntity);
        return getBookResponse(bookingEntity);
    }

    /**
     * Method for booking details
     *
     * @param bookId
     * @return bookingDetails
     */
    @Override
    public BookingResponse bookingDetails(Long bookId) {
        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(bookId);
        BookingEntity bookingEntity = bookingEntityOptional.get();
        return getBookResponse(bookingEntity);

    }

    /**
     * Method for adminBookingDetails
     *
     * @param frn_busId
     * @return adminDetails
     */
    @Override
    public List<BookingEntity> adminBookingDetails(@PathVariable Long frn_busId) {
        return bookingRepository.getBookingsById(frn_busId);
    }

    /**
     * GetBookResponse is custom method to get required details from database
     *
     * @param bookingEntity
     * @return bookingResponse
     */
    private BookingResponse getBookResponse(BookingEntity bookingEntity) {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookId(bookingEntity.getBookId());
        bookingResponse.setUserName(bookingEntity.getUserName());
        bookingResponse.setSeatsBooked(bookingEntity.getSeatsBooked());
        bookingResponse.setDate(bookingEntity.getBusEntity().getDate());
        bookingResponse.setBusType(bookingEntity.getBusEntity().getBusType());
        bookingResponse.setStartLocation(bookingEntity.getBusEntity().getStartLocation());
        bookingResponse.setEndLocation(bookingEntity.getBusEntity().getEndLocation());
        bookingResponse.setBusName(bookingEntity.getBusEntity().getBusName());
        return bookingResponse;
    }

    /**
     * Cancel Booking method
     *
     * @param bookId
     * @return book canceled
     */
    @Override
    public BookingResponse cancelBooking(@PathVariable long bookId) {
        BookingEntity bookingEntity = bookingRepository.getReferenceById(bookId);
        bookingRepository.delete(bookingEntity);
//        throw new InvalidMessageException("Successfully Deleted the bud with Id: " + bookId);
        return null;
    }
}
