package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;
import com.aunghan.stockmanagementsystem.service.FactoryStockTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class FactoryStockTransactionController {

    private final FactoryStockTransactionService service;

    @Autowired
    public FactoryStockTransactionController(FactoryStockTransactionService service) {
        this.service = service;
    }

    @GetMapping("/transactions/stock/incoming")
    public List<FactoryStockTransaction> getIncomingFactoryStockTransaction(){
        return service.getIncomingStocks();
    }

    @GetMapping("/transactions/stock/outgoing")
    public List<FactoryStockTransaction> getOutgoingFactoryStockTransactions(){
        return service.getOutgoingStocks();
    }

    @PostMapping("/transactions/stock/new")
    public FactoryStockTransaction addStockTransaction(@RequestBody FactoryStockTransaction newFactoryStockTransaction){
        return service.saveFactoryStockTransaction(newFactoryStockTransaction);
    }

}
