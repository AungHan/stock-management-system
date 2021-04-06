package com.aunghan.stockmanagementsystem.repository;

import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactoryStockTransactionRepository extends JpaRepository<FactoryStockTransaction, Integer> {
    //List<FactoryStockTransaction> findAllByDateRange(Date startDate, Date endDate);
    List<FactoryStockTransaction> findAllByTransactionType(String transactionType);
}
