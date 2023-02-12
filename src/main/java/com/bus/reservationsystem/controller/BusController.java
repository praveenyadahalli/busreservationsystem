package com.bus.reservationsystem.controller;

import com.bus.reservationsystem.representation.request.BusRequest;
import com.bus.reservationsystem.representation.response.BusResponse;
import com.bus.reservationsystem.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Bus Controller
 * <p>
 * Rest Api's for bus entity
 */

@RequestMapping("/bus")
@RestController
@Validated
public class BusController {

    @Autowired
    private BusService busService;

    /**
     * List of all the available buses
     *
     * @return list buses
     */
    @GetMapping
    public ResponseEntity<List<BusResponse>> getAllBuses() {
        List<BusResponse> busEntities = busService.getAllBuses();
        return new ResponseEntity<List<BusResponse>>(busEntities, HttpStatus.OK);
    }

    /**
     * Get Single bus by passing id
     *
     * @param busId
     * @return single bus
     */
    @GetMapping("/busId/{busId}")
    public ResponseEntity<BusResponse> getSingleBus(@PathVariable String busId) {
        BusResponse busResponse = busService.getSingleBus(busId);
        return new ResponseEntity<BusResponse>(busResponse, HttpStatus.OK);

    }


//    @GetMapping("/details/{busId}")
//    public ResponseEntity<BusResponse> bookingDetails(Long id) {
//        return null;
//    }

    /**
     * Add new bus details
     *
     * @param busEntity
     * @return addNewBus
     */
    @PostMapping
    public ResponseEntity<BusResponse> addNewBus(@RequestBody BusRequest busEntity) {
        BusResponse busResponse = busService.addNewBus(busEntity);
        return new ResponseEntity<>(busResponse, HttpStatus.OK);

    }

    /**
     * Update the bus entity
     *
     * @param busId
     * @param busEntity
     * @return updated bus
     */
    @PutMapping("/{busId}")
    public ResponseEntity<BusResponse> updateBus(@PathVariable String busId, @RequestBody BusRequest busEntity) {
        BusResponse busResponse = busService.updateBus(Long.parseLong(busId), busEntity);
        return new ResponseEntity<>(busResponse, HttpStatus.OK);
    }

    /**
     * Delete bus Entity by passing id
     *
     * @param busId
     * @return null
     */
    @DeleteMapping("/{busId}")
    public ResponseEntity<BusResponse> deleteBus(@PathVariable String busId) {
        BusResponse busResponse = busService.deleteBus(Long.parseLong(busId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
