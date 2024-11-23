package com.dsi301.shiptrackshipmentservice.repository;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import com.dsi301.shiptrackshipmentservice.interfaces.IShipmentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShipmentRepositoryImpl implements IShipmentRepository {
    private final List<Shipment> shipments;

    public ShipmentRepositoryImpl() {
        this.shipments = new ArrayList<>( List.of(
                new Shipment("1", "123 Main St", "Anytown", "12345", "2021-12-31", "12:00 PM", "SHIP-1", "2L","Created")
        ));
    }

    public Shipment findByTrackingNumber(String trackingNumber) {
        for (Shipment shipment : shipments) {
            if (shipment.getTrackingNumber().equals(trackingNumber)) {
                return shipment;
            }
        }
        return null;
    }

    public Shipment save(Shipment shipment) {
        shipments.add(shipment);
        shipment.setShipmentId((Math.random() * 1000) + "");
        return shipment;
    }
}
