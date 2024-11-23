package com.dsi301.shiptrackshipmentservice.endpoints;

import com.dsi301.shiptrackshipmentservice.entities.Shipment;
import com.dsi301.shiptrackshipmentservice.interfaces.IShipmentService;
import com.dsi301.xml.shipment.ShipmentDetailsRequest;
import com.dsi301.xml.shipment.ShipmentDetailsResponse;
import com.dsi301.xml.shipment.ShipmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ShipmentEndpoint {

    private static final String NAMESPACE_URI = "http://www.dsi301.com/xml/shipment";

    private final IShipmentService shipmentService;

    // Endpoint to get shipment details based on tracking number
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ShipmentDetailsRequest")
    @ResponsePayload
    public ShipmentDetailsResponse getShipment(@RequestPayload ShipmentDetailsRequest request) {
        ShipmentDetailsResponse response = new ShipmentDetailsResponse();
        Shipment shipment = shipmentService.getByTrackingNumber(request.getTrackingNumber());

        if (shipment != null) {
            response.setShipmentId(shipment.getShipmentId());
            response.setStreetAddress(shipment.getStreetAddress());
            response.setCity(shipment.getCity());
            response.setPostalCode(shipment.getPostalCode());
            response.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());
            response.setEstimatedPickupTime(shipment.getEstimatedPickupTime());
            response.setTrackingNumber(shipment.getTrackingNumber());
            response.setStatus(shipment.getStatus());
            response.setCarrierId(shipment.getCarrierId());
        }else{
            response.setShipmentId("0");
            response.setStreetAddress("N/A");
            response.setCity("N/A");
            response.setPostalCode("N/A");
            response.setEstimatedDeliveryDate("N/A");
            response.setEstimatedPickupTime("N/A");
            response.setTrackingNumber("N/A");
            response.setStatus("N/A");
            response.setCarrierId("N/A");
        }
        return response;
    }

    // Endpoint to create a new shipment
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ShipmentRequest")
    @ResponsePayload
    public ShipmentDetailsResponse createShipment(@RequestPayload ShipmentRequest request) {
        Shipment shipment = new Shipment();
        shipment.setStreetAddress(request.getStreetAddress());
        shipment.setCity(request.getCity());
        shipment.setPostalCode(request.getPostalCode());
        shipment.setTrackingNumber(shipmentService.generateTrackingNumber());
        shipment.setStatus("Created");

        // need to dispatch an event to handle other shipment details


        // Save shipment to the repository
        Shipment savedShipment = shipmentService.save(shipment);

        ShipmentDetailsResponse response = new ShipmentDetailsResponse();
        response.setShipmentId(savedShipment.getShipmentId());
        response.setTrackingNumber(savedShipment.getTrackingNumber());
        response.setStatus(savedShipment.getStatus());

        return response;
    }
}
