package com.dsi301.shiptrackshipmentservice;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import com.dsi301.shiptrackshipmentservice.services.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
@RequiredArgsConstructor
public class ShipmentEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap";

    private final ShipmentService shipmentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateShipmentRequest")
    @ResponsePayload
    public CreateShipmentResponse createShipment(@RequestPayload CreateShipmentRequest request) {
        Shipment shipment = shipmentService.createShipment(request);
        CreateShipmentResponse response = new CreateShipmentResponse();
        response.setShipmentId(shipment.getShipmentId());
        response.setTrackingNumber(shipment.getTrackingNumber());
        response.setStatus(shipment.getStatus().toString());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetShipmentDetailsRequest")
    @ResponsePayload
    public ShipmentDetailsResponse getShipmentDetails(@RequestPayload GetShipmentDetailsRequest request) {
        Shipment shipment = shipmentService.getShipmentByTrackingNumber(request.getTrackingNumber());
        ShipmentDetailsResponse response = new ShipmentDetailsResponse();
        response.setShipmentId(shipment.getShipmentId());
        response.setStreetAddress(shipment.getStreetAddress());
        response.setCity(shipment.getCity());
        response.setPostalCode(shipment.getPostalCode());
        response.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());
        response.setEstimatedPickupTime(shipment.getEstimatedPickupTime());
        response.setTrackingNumber(shipment.getTrackingNumber());
        response.setStatus(shipment.getStatus().toString());
        response.setCarrierId(shipment.getCarrierId());
        return response;
    }
}
