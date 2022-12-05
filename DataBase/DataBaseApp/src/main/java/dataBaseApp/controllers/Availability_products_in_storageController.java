package dataBaseApp.controllers;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import dataBaseApp.dto.Availability_products_in_storageRequest;
import dataBaseApp.entity.Availability_products_in_storage;
import dataBaseApp.pk.Availability_products_in_storagePK;
import dataBaseApp.repositories.Availability_products_in_storageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/availability_products_in_storage")
public class Availability_products_in_storageController {
    @Autowired
    private Availability_products_in_storageRepository availability_products_in_storageRepository;

    @CrossOrigin
    @PostMapping("/add")
    public String addNewAvailabilityProductsInStorage(@RequestBody Availability_products_in_storageRequest storageRequest) {
        Availability_products_in_storage storage = Availability_products_in_storage.fromDTO(storageRequest);
        availability_products_in_storageRepository.save(storage);
        return "saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Availability_products_in_storage> getAllAvailabilityProductsInStorage() {
        return availability_products_in_storageRepository.findAll();
    }


}
