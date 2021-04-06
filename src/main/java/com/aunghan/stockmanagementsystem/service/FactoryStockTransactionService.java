package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;

import java.util.Date;
import java.util.List;

public interface FactoryStockTransactionService {
    FactoryStockTransaction saveFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction);
    FactoryStockTransaction getFactoryStockTransactionById(int id);
    String deleteFactoryStockTransaction(int id);
    FactoryStockTransaction updateFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction);
    //List<FactoryStockTransaction> getFactoryStockTransactionByDateRange(Date startDate, Date endDate);
    List<FactoryStockTransaction> getIncomingStocks();
    List<FactoryStockTransaction> getOutgoingStocks();
}
