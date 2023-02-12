package com.bus.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * This Bus Entity
 * <p>
 * Bus entity contains the details of bus, it has busId as primary key
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bus")
public class BusEntity {
    /**
     * BusId as primary key in bus table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "busId")
    private Long busId;

    /**
     * BusName field for bus entity
     */
    @Pattern(regexp = "^[A-Za-z]+$",message = "Only Characters Allowed")
    @Size(max=15,min=3,message="Min 5 and Max 10 Characters")
    @NotBlank(message = "Bus Name is mandatory")
    @Column(name = "bus_name")
    private String busName;

    /**
     * Date field for bus entity
     */
    @Column(name = "date")
    private Date date;


    /**
     * BusType field gives info about Ac or NonAc type
     */
    @Pattern(regexp = "^[A-Za-z]+$",message = "Only Characters Allowed")
    @Size(max=5,min=2,message="Type AC or NonAC")
    @NotBlank(message = "Bus Type is mandatory")
    @Column(name = "bus_type")
    private String busType;

    /**
     * Bus StartLocation
     */
    @Pattern(regexp = "^[A-Za-z]+$",message = "Only Characters Allowed")
    @Size(max=15,min=3,message="Min 3 Max 15 Characters")
    @NotBlank(message = "Start Location is mandatory")
    @Column(name = "start_location")
    private String startLocation;

    /**
     * Bus EndLocation
     */
    @Pattern(regexp = "^[A-Za-z]+$",message = "Only Characters Allowed")
    @Size(max=15,min=3,message="Min 3 Max 15 Characters")
    @NotBlank(message = "End Location is mandatory")
    @Column(name = "end_location")
    private String endLocation;

    /**
     * NoOfSeats will provide total no of seats in the bus
     */
    @Min(value = 1,message = "Minimum 1 seats")
    @Max(value=50, message = "Maximum 50 seats")
    @Column(name = "no_of_seats")
    private Integer noOfSeats;

}
