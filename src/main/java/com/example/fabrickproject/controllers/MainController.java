package com.example.fabrickproject.controllers;
import com.example.fabrickproject.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    MainService mainService = new MainService();





    @GetMapping("/getBalance")
    public String getBalance() throws Exception {
        return mainService.getBalance();
    }
    @PostMapping("/createMoneyTransfer")
    public String createMoneyTransfer() throws Exception {
        return mainService.createMoneyTransfer();
    }
    @GetMapping("/getTrans")
    public String getTrans() throws Exception {
        return mainService.getTransactions();
    }
}
