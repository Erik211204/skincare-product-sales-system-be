package application.havenskin.service;

import application.havenskin.BusinessObject.Models.Shipments;
import application.havenskin.DTORequest.ShipmentDTO;
import application.havenskin.mapper.Mapper;
import application.havenskin.repository.ShipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentsRepository shipmentsRepository;
    @Autowired
    private Mapper mapper;
    public List<Shipments> getAllShipments() {
        return shipmentsRepository.findAll();
    }
    public Shipments getShipmentById(String id) {
        return shipmentsRepository.findById(id).get();
    }
    public Shipments createShipment(Shipments shipment) {
        return shipmentsRepository.save(shipment);
    }
    public Shipments updateShipment(String id, ShipmentDTO shipment) {
        Shipments x = shipmentsRepository.findById(id).orElseThrow(()-> new RuntimeException("Shipment not found"));
        mapper.updateShipments(x, shipment);
        return shipmentsRepository.save(x);
    }
    public void deleteShipment(String id) {
        if(!shipmentsRepository.existsById(id)) {
            throw new RuntimeException("Shipment with id " + id + " does not exist");
        }
        shipmentsRepository.deleteById(id);
    }
    public List<Shipments> addListOfShipments(List<Shipments> shipments) {
        return shipmentsRepository.saveAll(shipments);
    }
    public String searchOrderIDByShipmentCode(String orderID)
    {
        if(!shipmentsRepository.existsById(orderID)){
            throw new RuntimeException("Shipment with id " + orderID + " does not exist");
        }
        return shipmentsRepository.findById(orderID).get().getShipmentCode();
    }
}
