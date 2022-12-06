package dataBaseApp.controllers;

import dataBaseApp.dto.DeliveriesRequest;
import dataBaseApp.entity.Deliveries;
import dataBaseApp.repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/deliveries", path = "/deliveries")
public class DeliveriesController {
    @Autowired
    private DeliveriesRepository deliveriesRepository;

    @GetMapping
    public String deliveries(){
        return "deliveries/main";
    }

    @GetMapping(value = "/add", path = "/add")
    public String addNewDeliveries(Model model) {
        model.addAttribute("delivery", new DeliveriesRequest());
        return "deliveries/add";
    }
    @PostMapping
    public String create(@ModelAttribute("delivery")DeliveriesRequest delivery ){
        Deliveries deliveries = Deliveries.fromDTO(delivery);
        deliveriesRepository.save(deliveries);
        return "redirect:/";
    }
    @GetMapping(value = "/all", path = "/all")
    public String getAllDeliveries(Model model) {
        List<Deliveries> dList=deliveriesRepository.findAll();
        model.addAttribute("dList",dList);
        return "deliveries/all";
    }
}
