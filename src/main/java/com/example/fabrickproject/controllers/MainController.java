package com.example.fabrickproject.controllers;
import com.example.fabrickproject.payloads.BalancePayload;
import com.example.fabrickproject.payloads.TransactionPayload;
import com.example.fabrickproject.services.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    MainService mainService = new MainService();
    @GetMapping("/getBalance")
    public BalancePayload getBalance() throws Exception {
        return mainService.getBalance();
    }
    @PostMapping("/createMoneyTransfer")
    public String createMoneyTransfer() throws Exception {
        return mainService.createMoneyTransfer();
    }
    @GetMapping("/getTransactions")
    public TransactionPayload getTransactions() throws Exception {
        return mainService.getTransactions();
    }
}
