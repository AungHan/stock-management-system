package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody Category category){
        return service.saveCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return service.getCategories();
    }

    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable int id){
        return service.getCategoryById(id);
    }

    @PutMapping("/category/update")
    public Category updateCategory(@RequestBody Category category){
        return service.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id){
        return service.deleteCategory(id);
    }
}
