package DataBaseApp.Controllers;

import DataBaseApp.Accounting_deliveries;
import DataBaseApp.Deliveries;
import DataBaseApp.Repositories.Accounting_deliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/accounting-deliveries")
public class Accounting_deliveriesController {
    @Autowired
    private Accounting_deliveriesRepository accountingDeliveriesRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewAccountingDeliveries(@RequestParam Long id_contract, @RequestParam Long id_product,
                                                           String unit, Integer count_products, Date date_of_admission){
        Accounting_deliveries accountingDeliveries = new Accounting_deliveries();
        accountingDeliveries.setId_contract(id_contract);
        accountingDeliveries.setId_product(id_product);
        accountingDeliveries.setUnit(unit);
        accountingDeliveries.setCount_products(count_products);
        accountingDeliveries.setDate_of_admission(date_of_admission);
        return "Saved";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Accounting_deliveries> getAllAccountingDeliveries(){
        return accountingDeliveriesRepository.findAll();
    }
}
