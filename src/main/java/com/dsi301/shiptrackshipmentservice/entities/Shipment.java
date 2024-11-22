package com.dsi301.shiptrackshipmentservice.entities;

import com.dsi301.shiptrackshipmentservice.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipmentId;

    private String streetAddress;
    private String city;
    private String postalCode;
    private String estimatedDeliveryDate;
    private String estimatedPickupTime;
    private int carrierId;
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

}
