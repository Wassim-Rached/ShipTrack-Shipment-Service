package com.dsi301.shiptrackshipmentservice;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
public class ShipmentDetailsResponse {
    private int shipmentId;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String estimatedDeliveryDate;
    private String estimatedPickupTime;
    private String trackingNumber;
    private String status;
    private int carrierId;
}
