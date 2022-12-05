package dataBaseApp.controllers;

import dataBaseApp.dto.DeliveriesRequest;
import dataBaseApp.entity.Deliveries;
import dataBaseApp.repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/deliveries", path = "/deliveries")
public class DeliveriesController {
    @Autowired
    private DeliveriesRepository deliveriesRepository;

    @CrossOrigin
    @PostMapping(value = "/add", path = "/add")
    public String addNewDeliveries(@RequestBody final DeliveriesRequest deliveriesRequest) {
        Deliveries deliveries = Deliveries.fromDTO(deliveriesRequest);
        deliveriesRepository.save(deliveries);
        return "saved";
    }

    @GetMapping(value = "/all", path = "/all")
    public @ResponseBody Iterable<Deliveries> getAllDeliveries() {
        return deliveriesRepository.findAll();
    }
}
