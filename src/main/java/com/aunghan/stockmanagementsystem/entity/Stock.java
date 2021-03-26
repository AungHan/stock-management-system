package com.aunghan.stockmanagementsystem.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="stock_name")
    private String stockName;

    @Column(name="stock_description")
    private String stockDescription;

    @Column(name="is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Stock(){}

    public String toString(){
        return "Stock [" + id + ", " + stockName + "]";
    }
}
