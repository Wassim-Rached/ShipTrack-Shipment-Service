package com.dsi301.shiptrackshipmentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    private String shipmentId;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String estimatedDeliveryDate;
    private String estimatedPickupTime;
    private String trackingNumber;
    private String carrierId;
    private String status;

}
