package com.dsi301.shiptrackshipmentservice.repositories;
import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    Optional<Shipment> findByTrackingNumber(String trackingNumber);
}
