package com.bus.reservationsystem.service;

import com.bus.reservationsystem.entity.BusEntity;
import com.bus.reservationsystem.repository.BusRepository;
import com.bus.reservationsystem.representation.request.BusRequest;
import com.bus.reservationsystem.representation.response.BusResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Bus Service Implementation
 * <p>
 * BusServiceImplementation will implement all the present in busService
 */
@NoArgsConstructor
@Service
public class BusServiceImpl implements BusService {

    /**
     * AutoWiring busRepository to access data
     */
    @Autowired
    private BusRepository busRepository;

    /**
     * Method to get List of BusEntity
     *
     * @return busEntityList
     */
    @Override
    public List<BusResponse> getAllBuses() {
        List<BusEntity> busEntities = busRepository.findAll();
        List<BusResponse> busResponses = new ArrayList<>();
        for (BusEntity busEntity : busEntities) {
            busResponses.add(getResponse(busEntity));
        }
        return busResponses;
    }

    /**
     * Method to getSingleBus
     *
     * @param busId
     * @return singleBus
     */
    @Override
    public BusResponse getSingleBus(String busId) {
        Optional<BusEntity> busEntityOptional = busRepository.findById(Long.parseLong(busId));
        BusEntity busEntity = busEntityOptional.get();
        return getResponse(busEntity);


    }

    /**
     * Method to get Single Bus
     *
     * @param busId
     * @return singleBus
     */
    @Override
    public BusEntity findBusById(String busId) {
        Optional<BusEntity> busEntity = busRepository.findById(Long.parseLong(busId));
        BusEntity busEntity1 = busEntity.get();

        return busEntity1;
    }

    /**
     * Method to add new Bus
     *
     * @param busRequest
     * @return newBus
     */
    @Override
    public BusResponse addNewBus(BusRequest busRequest) {
        BusEntity busEntity = new BusEntity();
//        try {
            busEntity.setBusType(busRequest.getBusType());
            busEntity.setBusName(busRequest.getBusName());
            busEntity.setDate(busRequest.getDate());
            busEntity.setStartLocation(busRequest.getStartLocation());
            busEntity.setEndLocation(busRequest.getEndLocation());
            busEntity.setNoOfSeats(busRequest.getNoOfSeats());
            busRepository.save(busEntity);
//        } catch (MethodArgumentNotValidException e) {
//            e.printStackTrace();
//        }
        return getResponse(busEntity);
    }

    /**
     * Custom method for getResponse from BusEntity
     *
     * @param busEntity
     * @return busResponse
     */
    private BusResponse getResponse(BusEntity busEntity) {
        BusResponse busResponse = new BusResponse();
        busResponse.setBusType(busEntity.getBusType());
        busResponse.setBusName(busEntity.getBusName());
        busResponse.setStartLocation(busEntity.getStartLocation());
        busResponse.setEndLocation(busEntity.getEndLocation());
        busResponse.setNoOfSeats(busEntity.getNoOfSeats());
        busResponse.setDate(busEntity.getDate());
        busResponse.setBusId(busEntity.getBusId());
        return busResponse;
    }

    /**
     * Update Bus Method
     *
     * @param busId
     * @param busRequest
     * @return updatedBus
     */
    @Override
    public BusResponse updateBus(@PathVariable long busId, BusRequest busRequest) {
        BusEntity busEntity = busRepository.getReferenceById(busId);
//        if (busEntity == null) throw new InvalidMessageException("No Bus found with the id: " + busId);
//        try {
            busEntity.setBusType(busRequest.getBusType());
            busEntity.setBusName(busRequest.getBusName());
            busEntity.setDate(busRequest.getDate());
            busEntity.setStartLocation(busRequest.getStartLocation());
            busEntity.setEndLocation(busRequest.getEndLocation());
            busEntity.setNoOfSeats(busRequest.getNoOfSeats());
            busRepository.save(busEntity);
//        } catch (Throwable throwable) {
//            throw new InvalidMessageException("Body Incorrect");
//        }

        return getResponse(busEntity);
    }

    /**
     * Method to delete a Bus
     *
     * @param parseLong
     * @return deleteBus
     */
    @Override
    public BusResponse deleteBus(@PathVariable long parseLong) {
        BusEntity busEntity = busRepository.getReferenceById(parseLong);
        busRepository.delete(busEntity);
//        throw new InvalidMessageException("Successfully Deleted the bus with Id: " + parseLong);
        return null;
    }
}
