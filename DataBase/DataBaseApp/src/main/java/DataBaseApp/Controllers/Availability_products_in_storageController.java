package DataBaseApp.Controllers;

import DataBaseApp.Availability_products_in_storage;
import DataBaseApp.Repositories.Availability_products_in_storageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/availability_products_in_storage")
public class Availability_products_in_storageController {
    @Autowired
    private Availability_products_in_storageRepository availability_products_in_storageRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewAvailabilityProductsInStorage(@RequestParam Long id_storage, @RequestParam Long id_product, String unit,
                                                                 Integer count_in_storage, Date date_last_operation){
        Availability_products_in_storage availabilityProductsInStorage = new Availability_products_in_storage();
        availabilityProductsInStorage.setId_storage(id_storage);
        availabilityProductsInStorage.setId_product(id_product);
        availabilityProductsInStorage.setUnit(unit);
        availabilityProductsInStorage.setCount_in_storage(count_in_storage);
        availabilityProductsInStorage.setDate_last_operation(date_last_operation);
        availability_products_in_storageRepository.save(availabilityProductsInStorage);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Availability_products_in_storage> getAllAvailabilityProductsInStorage(){
        return availability_products_in_storageRepository.findAll();
    }




}
