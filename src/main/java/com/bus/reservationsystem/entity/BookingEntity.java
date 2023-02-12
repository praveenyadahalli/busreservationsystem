package com.bus.reservationsystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * This is booking entity
 * <p>
 * Booking entity for bus registration system, table name is given as book
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookingEntity {
    /**
     * BookId is the field, it is primary key for book table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    /**
     * Username field
     */
    @Pattern(regexp = "^[A-Za-z]+$",message = "Only Characters Allowed")
    @Size(max=15,min=3,message="Min 3 Max 15 Characters")
    @NotBlank(message = "Username is mandatory")
    @Column(name = "user_name")
    private String userName;

    /**
     * Total Seats of the user field
     */
    @Min(value = 1,message = "Minimum 1 seats")
    @Max(value=50, message = "Maximum 50 seats")
    @Column(name = "seats_booked")
    private Integer seatsBooked;

    /**
     * Many to One mapping between book table and bus table
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "frn_busId", referencedColumnName = "busId")
    private BusEntity busEntity;


}
