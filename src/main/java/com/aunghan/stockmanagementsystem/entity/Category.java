package com.aunghan.stockmanagementsystem.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="category_description")
    private String categoryDescription;

    @Column(name="is_active")
    private boolean isActive;

    public Category(){}

    public Category(String name, String description, boolean isActive){
        this.categoryName = name;
        this.categoryDescription = description;
        this.isActive = isActive;
    }

    public String toString(){
        return "Category [" + id + ", " + categoryName + "]";
    }
}
