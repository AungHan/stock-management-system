package com.aunghan.stockmanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="factory_stock_transaction")
public class FactoryStockTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="process_date")
    private Date processDate;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name="quantity")
    private String quantity;

    @Column(name="price")
    private double price;

    @Column(name="total_amount")
    private double totalAmount;

    @Column(name="is_active")
    private boolean isActive;

    @OneToOne
    @JoinColumn(name="stock_id")
    private Stock stock;

    @Override
    public String toString(){
        return String.format("id={}, type={}, stock={}", this.getId(), this.getTransactionType(), this.getStock());
    }
}
