package com.bus.reservationsystem.repository;

import com.bus.reservationsystem.entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Bus Repository
 * <p>
 * This is the BusRepository for book table
 */
public interface BusRepository extends JpaRepository<BusEntity, Long> {

}
