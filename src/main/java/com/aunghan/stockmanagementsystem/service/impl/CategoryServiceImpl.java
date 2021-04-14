package com.aunghan.stockmanagementsystem.service.impl;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.entity.Stock;
import com.aunghan.stockmanagementsystem.repository.CategoryRepository;
import com.aunghan.stockmanagementsystem.service.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category saveCategory(Category category){
        return repository.save(category);
    }

    @Override
    public List<Category> getCategories(){
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName){
        return repository.findByCategoryName(categoryName);
    }

    @Override
    public String deleteCategory(int id){
        repository.deleteById(id);
        return "deleted category, id=" + id;
    }

    @Override
    public Category updateCategory(Category category){
        Category current = getCategoryById(category.getId());
        if (current != null){
            current.setCategoryName(category.getCategoryName());
            current.setCategoryDescription(category.getCategoryDescription());
            current.setActive(category.isActive());

            return saveCategory(current);
        }
        return null;
    }

    public String setActiveStatus(int id, boolean isActive){
        Category current = getCategoryById(id);
        if (current == null) return "No stock existed with given id " + id;

        current.setActive(isActive);
        saveCategory(current);
        return "Stock item active status was updated for id " + id;
    }
}
