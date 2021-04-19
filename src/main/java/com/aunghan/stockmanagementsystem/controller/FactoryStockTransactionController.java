package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;
import com.aunghan.stockmanagementsystem.service.FactoryStockTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/transactions/stock")
public class FactoryStockTransactionController {

    private final FactoryStockTransactionService service;

    @Autowired
    public FactoryStockTransactionController(FactoryStockTransactionService service) {
        this.service = service;
    }

    @GetMapping(value = "", params = "transactionType")
    public ResponseEntity<List<FactoryStockTransaction>> getFactoryStockTransactions(@RequestParam String transactionType){
        log.info("get list");
        if(transactionType == null || transactionType.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(service.getStockTransactions(transactionType), HttpStatus.OK);
    }

    @GetMapping("/incoming")
    public List<FactoryStockTransaction> getIncomingFactoryStockTransaction(){
        return service.getIncomingStocks();
    }

    @GetMapping("/outgoing")
    public List<FactoryStockTransaction> getOutgoingFactoryStockTransactions(){
        return service.getOutgoingStocks();
    }

    @PostMapping("")
    public FactoryStockTransaction addStockTransaction(@RequestBody FactoryStockTransaction newFactoryStockTransaction){
        return service.saveFactoryStockTransaction(newFactoryStockTransaction);
    }

    @DeleteMapping("/{id}")
    public String deleteFactoryStockTransaction(@PathVariable("id") int id){
        return service.deleteFactoryStockTransaction(id);
    }

    @GetMapping("/{id}")
    public FactoryStockTransaction getStockTransactionById(@PathVariable("id") int id){
        return service.getFactoryStockTransactionById(id);
    }

    @PutMapping("/update")
    public FactoryStockTransaction updateStockTransaction(@RequestBody FactoryStockTransaction updateFactoryStockTransaction){
        return service.updateFactoryStockTransaction(updateFactoryStockTransaction);
    }
}
