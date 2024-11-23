package com.dsi301.shiptrackshipmentservice.services;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import com.dsi301.shiptrackshipmentservice.interfaces.IShipmentRepository;
import com.dsi301.shiptrackshipmentservice.interfaces.IShipmentService;
import com.dsi301.shiptrackshipmentservice.repository.ShipmentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements IShipmentService {

    private final IShipmentRepository shipmentRepository;

    @Override
    public String generateTrackingNumber() {
        // algorithm to generate tracking number SHIP-<random 6 digit number>
        int random = (int) (Math.random() * 1000000);
        return "SHIP-" + random;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }
}
