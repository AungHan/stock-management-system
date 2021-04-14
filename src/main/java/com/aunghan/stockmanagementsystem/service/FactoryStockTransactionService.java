package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;

import java.util.List;

public interface FactoryStockTransactionService {
    FactoryStockTransaction saveFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction);

    FactoryStockTransaction getFactoryStockTransactionById(int id);

    String deleteFactoryStockTransaction(int id);

    FactoryStockTransaction updateFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction);

    List<FactoryStockTransaction> getIncomingStocks();

    List<FactoryStockTransaction> getOutgoingStocks();

    List<FactoryStockTransaction> getStockTransactions(String transactionType);
}
