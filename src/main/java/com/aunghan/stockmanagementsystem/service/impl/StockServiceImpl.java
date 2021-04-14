package com.aunghan.stockmanagementsystem.service.impl;

import com.aunghan.stockmanagementsystem.entity.Stock;
import com.aunghan.stockmanagementsystem.repository.StockRepository;
import com.aunghan.stockmanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository repository;

    @Autowired
    public StockServiceImpl(StockRepository repository){
        this.repository = repository;
    }

    @Override
    public Stock saveStock(Stock stock){
        return repository.save(stock);
    }

    @Override
    public List<Stock> getStocks(){
        return repository.findAll();
    }

    @Override
    public Stock getStockById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public String deleteStock(int id){
        repository.deleteById(id);
        return "deleted stock, id=" + id;
    }

    @Override
    public Stock updateStock(Stock stock){
        Stock currentStock = getStockById(stock.getId());
        if (currentStock == null) return null;

        currentStock.setStockName(stock.getStockName());
        currentStock.setStockDescription(stock.getStockDescription());
        currentStock.setIsActive(stock.getIsActive());
        currentStock.setCategory(stock.getCategory());

        return saveStock(currentStock);
    }

    public String setActiveStatus(int id, boolean isActive){
        Stock current = getStockById(id);
        if (current == null) return "No stock existed with given id " + id;

        current.setIsActive(isActive);
        saveStock(current);
        return "Stock item active status was updated for id " + id;
    }

    @Override
    public Stock getStockByStockName(String stockName){
        return repository.findByStockName(stockName);
    }
}
