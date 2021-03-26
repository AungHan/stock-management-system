package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Stock;
import com.aunghan.stockmanagementsystem.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository repository;

    @Autowired
    public StockService(StockRepository repository){
        this.repository = repository;
    }

    public Stock saveStock(Stock stock){
        return repository.save(stock);
    }

    public List<Stock> getStocks(){
        return repository.findAll();
    }

    public Stock getStockById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteStock(int id){
        repository.deleteById(id);
        return "deleted stock, id=" + id;
    }

    public Stock updateStock(Stock stock){
        Stock currentStock = getStockById(stock.getId());
        if (currentStock == null) return null;

        currentStock.setStockName(stock.getStockName());
        currentStock.setStockDescription(stock.getStockDescription());
        currentStock.setIsActive(stock.getIsActive());
        currentStock.setCategory(stock.getCategory());

        return saveStock(currentStock);
    }

    public Stock findByStockName(String stockName){
        return repository.findByStockName(stockName);
    }
}
