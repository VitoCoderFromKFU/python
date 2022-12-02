package dataBaseApp.controllers;

import dataBaseApp.data.Deliveries;
import dataBaseApp.repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping(value = "/deliveries",path = "/deliveries")
public class DeliveriesController {
    @Autowired
    private DeliveriesRepository deliveriesRepository;

    @PostMapping(value = "/add",path = "/add")
    public @ResponseBody String addNewDeliveries(@RequestParam Long id_product, String unit, LocalDate start_date,
                                                 LocalDate end_date, Integer plan_delivery, Double price_unit){
        Deliveries deliveries = new Deliveries();
        //deliveries.setId_product(id_product);
        deliveries.setUnit(unit);
        deliveries.setStart_date(start_date);
        deliveries.setEnd_date(end_date);
        deliveries.setPlan_delivery(plan_delivery);
        deliveries.setPrice_unit(price_unit);
        deliveriesRepository.save(deliveries);
        return "Saved";
    }
    @GetMapping(value = "/all",path = "/all")
    public @ResponseBody Iterable<Deliveries> getAllDeliveries(){
        return deliveriesRepository.findAll();
    }
}
