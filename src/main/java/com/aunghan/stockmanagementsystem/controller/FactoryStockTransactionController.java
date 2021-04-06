package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.FactoryStockTransaction;
import com.aunghan.stockmanagementsystem.service.FactoryStockTransactionService;
import com.aunghan.stockmanagementsystem.util.AttributeNames;
import com.aunghan.stockmanagementsystem.util.FactoryStockMappings;
import com.aunghan.stockmanagementsystem.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class FactoryStockTransactionController {

    private final FactoryStockTransactionService service;

    @Autowired
    public FactoryStockTransactionController(FactoryStockTransactionService service) {
        this.service = service;
    }

    @GetMapping(FactoryStockMappings.INCOMING)
    public String stockIncoming(Model model){
        List<FactoryStockTransaction> incomingStockList = service.getIncomingStocks();
        for(FactoryStockTransaction stock : incomingStockList){
            log.info(stock.toString());
        }
        model.addAttribute(AttributeNames.INCOMING_STOCK_LIST, incomingStockList);
        return ViewNames.INCOMING_STOCK;
    }
}
