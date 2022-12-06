package dataBaseApp.controllers;

import dataBaseApp.dto.Accounting_deliveriesRequest;
import dataBaseApp.entity.Accounting_deliveries;
import dataBaseApp.repositories.Accounting_deliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accountingDeliveries")
public class Accounting_deliveriesController {
    @Autowired
    private Accounting_deliveriesRepository accountingDeliveriesRepository;

    @GetMapping
    public String accountingDeliveries() {
        return "accountingDeliveries/main";
    }

    //@CrossOrigin//to work with postman
    @GetMapping("/add")
    public String addNewAccountingDeliveriesController(Model model) {
        model.addAttribute("acDelivery", new Accounting_deliveriesRequest());
        return "accountingDeliveries/add";

    }
    @PostMapping
    public String create (@ModelAttribute("acDelivery")Accounting_deliveriesRequest accountingDeliveriesRequest){
        Accounting_deliveries acDeliveries = Accounting_deliveries.fromDTO(accountingDeliveriesRequest);
        accountingDeliveriesRepository.save(acDeliveries);
        return "redirect:/";
    }
    @CrossOrigin
    @GetMapping("/all")
    public String getAllAccountingDeliveries(Model model) {
        List<Accounting_deliveries> adList = accountingDeliveriesRepository.findAll();
        model.addAttribute("adList", adList);
        return "accountingDeliveries/all";
    }

}
