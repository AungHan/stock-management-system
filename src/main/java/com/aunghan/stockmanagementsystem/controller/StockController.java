package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Stock;
import com.aunghan.stockmanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    @Autowired
    public StockController(StockService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Stock findStockById(@PathVariable("id") int id){
        return service.getStockById(id);
    }

    @GetMapping("")
    public List<Stock> getStocks(){
        return service.getStocks();
    }

    @PostMapping("")
    public Stock addStock(@RequestBody Stock stock){
        return service.saveStock(stock);
    }

    @PutMapping("/update")
    public Stock updateStock(@RequestBody Stock stock){
        return service.updateStock(stock);
    }

    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable("id") int id){
        return service.setActiveStatus(id, false);
    }
}
