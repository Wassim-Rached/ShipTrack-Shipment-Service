package com.dsi301.shiptrackshipmentservice.interfaces;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;

public interface IShipmentRepository {
    Shipment findByTrackingNumber(String trackingNumber);
    Shipment save(Shipment shipment);
}
