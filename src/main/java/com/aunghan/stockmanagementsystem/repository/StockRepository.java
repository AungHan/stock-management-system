package com.aunghan.stockmanagementsystem.repository;

import com.aunghan.stockmanagementsystem.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByStockName(String stockName);
}
