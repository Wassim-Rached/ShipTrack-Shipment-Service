package com.dsi301.shiptrackshipmentservice.services;

import com.dsi301.shiptrackshipmentservice.CreateShipmentRequest;
import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import com.dsi301.shiptrackshipmentservice.enums.ShipmentStatus;
import com.dsi301.shiptrackshipmentservice.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public Shipment createShipment(CreateShipmentRequest request) {
        Shipment shipment = new Shipment();
        shipment.setStreetAddress(request.getStreetAddress());
        shipment.setCity(request.getCity());
        shipment.setPostalCode(request.getPostalCode());
        shipment.setEstimatedDeliveryDate(request.getEstimatedDeliveryDate());
        shipment.setEstimatedPickupTime(request.getEstimatedPickupTime());
        shipment.setCarrierId(request.getCarrierId());
        shipment.setTrackingNumber(request.getTrackingNumber());
        shipment.setStatus(ShipmentStatus.CREATED);

        return shipmentRepository.save(shipment);
    }

    public Shipment getShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }
}
