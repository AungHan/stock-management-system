package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;
import com.aunghan.stockmanagementsystem.repository.FactoryStockTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactoryStockTransactionServiceImpl implements FactoryStockTransactionService {
    private final FactoryStockTransactionRepository repository;

    @Autowired
    public FactoryStockTransactionServiceImpl(FactoryStockTransactionRepository factoryStockTransactionRepository) {
        this.repository = factoryStockTransactionRepository;
    }

    public FactoryStockTransaction saveFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction){
        return this.repository.save(factoryStockTransaction);
    }

    public FactoryStockTransaction getFactoryStockTransactionById(int id){
        return this.repository.findById(id).orElse(null);
    }

    public String deleteFactoryStockTransaction(int id){
        repository.deleteById(id);
        return "deleted stock transaction, id=" + id;
    }

    public FactoryStockTransaction updateFactoryStockTransaction(FactoryStockTransaction factoryStockTransaction){
        FactoryStockTransaction current = getFactoryStockTransactionById(factoryStockTransaction.getId());
        if (current == null) return null;

        current.setProcessDate(factoryStockTransaction.getProcessDate());
        current.setTransactionType(factoryStockTransaction.getTransactionType());
        current.setQuantity(factoryStockTransaction.getQuantity());
        current.setPrice(factoryStockTransaction.getPrice());
        current.setTotalAmount(factoryStockTransaction.getTotalAmount());
        current.setActive(factoryStockTransaction.isActive());
        current.setStock(factoryStockTransaction.getStock());

        return saveFactoryStockTransaction(current);
    }

    // public List<FactoryStockTransaction> getFactoryStockTransactionByDateRange(Date startDate, Date endDate){
    // return repository.findAllByDateRange(startDate, endDate);
    // }

    public List<FactoryStockTransaction> getIncomingStocks(){
        //return repository.findAll();
        return repository.findAllByTransactionType("incoming");
    }

    public List<FactoryStockTransaction> getOutgoingStocks(){
        return repository.findAllByTransactionType("outgoing");
    }
}
