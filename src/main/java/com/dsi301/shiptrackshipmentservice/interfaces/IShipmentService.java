package com.dsi301.shiptrackshipmentservice.interfaces;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;

public interface IShipmentService {
    String generateTrackingNumber();
    Shipment save(Shipment shipment);
    Shipment getByTrackingNumber(String trackingNumber);
}
