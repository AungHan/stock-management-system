package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Stock;

import java.util.List;

public interface StockService {
    Stock saveStock(Stock stock);

    List<Stock> getStocks();

    Stock getStockById(int id);

    String deleteStock(int id);

    Stock updateStock(Stock stock);

    Stock getStockByStockName(String stockName);

    String setActiveStatus(int id, boolean isActive);
}
