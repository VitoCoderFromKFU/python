package dataBaseApp.controllers;


import dataBaseApp.dto.ForTask1;
import dataBaseApp.dto.ForTask2;
import dataBaseApp.dto.ForTask3;
import dataBaseApp.repositories.Accounting_deliveriesRepository;
import dataBaseApp.repositories.Availability_products_in_storageRepository;
import dataBaseApp.repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private Accounting_deliveriesRepository accountingDeliveriesRepository;
    private DeliveriesRepository deliveriesRepository;
    private Availability_products_in_storageRepository availabilityProductsInStorageRepository;
    @Autowired
    TasksController(Accounting_deliveriesRepository accountingDeliveriesRepository,
                    DeliveriesRepository deliveriesRepository,Availability_products_in_storageRepository availabilityProductsInStorageRepository){
        this.accountingDeliveriesRepository=accountingDeliveriesRepository;
        this.deliveriesRepository=deliveriesRepository;
        this.availabilityProductsInStorageRepository=availabilityProductsInStorageRepository;
    }
    @GetMapping
    public String tasks(){
        return "tasks";
    }

    @GetMapping("/task1")
    public String task1(Model model){
        List<ForTask1> task1 = accountingDeliveriesRepository.taskOne();
        model.addAttribute("t1List",task1);
        return "task1";
    }
    @GetMapping("/task2")
    public String task2(Model model){
        List<ForTask2> task2 = accountingDeliveriesRepository.taskTwo();
        model.addAttribute("task2List",task2);
        return "task2";
    }
    @GetMapping("/task3")
    public String task3(Model model){
        List<ForTask3> task3 = availabilityProductsInStorageRepository.taskThree();
        model.addAttribute("task3List",task3);
        return "task3";
    }
}
