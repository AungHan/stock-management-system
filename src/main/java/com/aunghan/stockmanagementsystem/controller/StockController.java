package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Stock;
import com.aunghan.stockmanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class StockController {

    private final StockService service;

    @Autowired
    public StockController(StockService service){
        this.service = service;
    }

    @GetMapping("/stock/{id}")
    public Stock findStockById(@PathVariable int id){
        return service.getStockById(id);
    }

    @GetMapping("/stocks")
    public List<Stock> getStocks(){
        return service.getStocks();
    }

    @PostMapping("/stock/add")
    public Stock addStock(@RequestBody Stock stock){
        return service.saveStock(stock);
    }

    @PutMapping("/stock/update")
    public Stock updateStock(@RequestBody Stock stock){
        return service.updateStock(stock);
    }

    @DeleteMapping("/stock/{id}")
    public String deleteStock(@PathVariable int id){
        return service.deleteStock(id);
    }
}
