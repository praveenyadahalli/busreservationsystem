package com.bus.reservationsystem.service;

import com.bus.reservationsystem.entity.BusEntity;
import com.bus.reservationsystem.representation.request.BusRequest;
import com.bus.reservationsystem.representation.response.BusResponse;

import java.util.List;

/**
 * Bus Service
 * <p>
 * BusService contains 6 methods
 */
public interface BusService {
    public List<BusResponse> getAllBuses();

    public BusResponse getSingleBus(String busId);

    public BusEntity findBusById(String busId);

    public BusResponse addNewBus(BusRequest busRequest);

    public BusResponse updateBus(long busId, BusRequest busRequest);

    public BusResponse deleteBus(long parseLong);
}
