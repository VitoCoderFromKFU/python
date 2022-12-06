package dataBaseApp.controllers;

import dataBaseApp.dto.Availability_products_in_storageRequest;
import dataBaseApp.entity.Availability_products_in_storage;
import dataBaseApp.repositories.Availability_products_in_storageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/availabilityProductsInStorage")
public class Availability_products_in_storageController {
    @Autowired
    private Availability_products_in_storageRepository availability_products_in_storageRepository;

    @GetMapping
    public String availabilityProductsInStorage(){
        return "availabilityProductsInStorage/main";
    }

    @CrossOrigin
    @GetMapping("/add")
    public String addNewAvailabilityProductsInStorage(Model model) {
        model.addAttribute("apis", new Availability_products_in_storageRequest());
        return "availabilityProductsInStorage/add";
    }
    @PostMapping
    public String create(@ModelAttribute("apis")Availability_products_in_storageRequest storageRequest){
        Availability_products_in_storage storage = Availability_products_in_storage.fromDTO(storageRequest);
        availability_products_in_storageRepository.save(storage);
        return "redirect:/";
    }
    @GetMapping("/all")
    public String getAllAvailabilityProductsInStorage(Model model) {
        List<Availability_products_in_storage> apisList = availability_products_in_storageRepository.findAll();
        model.addAttribute("apis",apisList);
        return "availabilityProductsInStorage/all";
    }


}
