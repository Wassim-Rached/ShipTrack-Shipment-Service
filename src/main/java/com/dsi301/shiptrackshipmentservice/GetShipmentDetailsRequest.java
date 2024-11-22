package com.dsi301.shiptrackshipmentservice;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Setter;

@XmlRootElement
@Setter
public class GetShipmentDetailsRequest {

    private String trackingNumber;

    @XmlElement
    public String getTrackingNumber() {
        return trackingNumber;
    }
}
