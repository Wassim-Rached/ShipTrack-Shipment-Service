package com.dsi301.shiptrackshipmentservice;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
public class CreateShipmentResponse {
    private int shipmentId;
    private String trackingNumber;
    private String status;
}
