package com.bus.reservationsystem.repository;

import com.bus.reservationsystem.entity.BookingEntity;
import com.bus.reservationsystem.representation.response.BookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * BookingRepository
 * <p>
 * This is the booking repository for Booking Table
 */
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    /**
     * Query to get all the registered user for a particular bus
     *
     * @param frn_busId
     * @return
     */
    @Query(value = "SELECT * from book WHERE frn_bus_id=?1", nativeQuery = true)
    public List<BookingEntity> getBookingsById(Long frn_busId);
}
