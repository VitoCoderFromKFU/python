package DataBaseApp.Controllers;

import DataBaseApp.Deliveries;
import DataBaseApp.Repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/deliveries")
public class DeliveriesController {
    @Autowired
    private DeliveriesRepository deliveriesRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewDeliveries(@RequestParam Long id_product, String unit, Date start_date,
                                              Date end_date,Integer plan_delivery, Double price_unit){
        Deliveries deliveries = new Deliveries();
        deliveries.setId_product(id_product);
        deliveries.setUnit(unit);
        deliveries.setStart_date(start_date);
        deliveries.setEnd_date(end_date);
        deliveries.setPlan_delivery(plan_delivery);
        deliveries.setPrice_unit(price_unit);
        deliveriesRepository.save(deliveries);
        return "Saved";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Deliveries> getAllDeliveries(){
        return deliveriesRepository.findAll();
    }
}
