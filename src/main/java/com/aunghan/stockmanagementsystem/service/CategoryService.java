package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category saveCategory(Category category){
        return repository.save(category);
    }

    public List<Category> getCategories(){
        return repository.findAll();
    }

    public Category getCategoryById(int id){
        return repository.findById(id).orElse(null);
    }

    public Category getCategoryByCategoryName(String categoryName){
        return repository.findByCategoryName(categoryName);
    }

    public String deleteCategory(int id){
        repository.deleteById(id);
        return "deleted category, id=" + id;
    }

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
}
