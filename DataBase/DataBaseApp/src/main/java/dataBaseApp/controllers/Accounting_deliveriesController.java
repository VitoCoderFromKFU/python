package dataBaseApp.controllers;

import dataBaseApp.dto.Accounting_deliveriesRequest;
import dataBaseApp.entity.Accounting_deliveries;
import dataBaseApp.entity.Availability_products_in_storage;
import dataBaseApp.entity.Deliveries;
import dataBaseApp.repositories.Accounting_deliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/accounting-deliveries")
public class Accounting_deliveriesController {
    @Autowired
    private Accounting_deliveriesRepository accountingDeliveriesRepository;

    @CrossOrigin//to work with postman
    @PostMapping("/add")
    public String addNewAccountingDeliveries(@RequestBody final Accounting_deliveriesRequest accountingDeliveriesRequest) {
        Accounting_deliveries accountingDeliveries = Accounting_deliveries.fromDTO(accountingDeliveriesRequest);
        accountingDeliveriesRepository.save(accountingDeliveries);
        return "saved";

    }

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody Iterable<Accounting_deliveries> getAllAccountingDeliveries() {
        return accountingDeliveriesRepository.findAll();
    }

}
