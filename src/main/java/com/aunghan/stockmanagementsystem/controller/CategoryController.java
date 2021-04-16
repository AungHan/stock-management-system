package com.aunghan.stockmanagementsystem.controller;

import com.aunghan.stockmanagementsystem.entity.Category;
import com.aunghan.stockmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category){
        return service.saveCategory(category);
    }

    @GetMapping("")
    public List<Category> getCategories(){
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable int id){
        return service.getCategoryById(id);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category){
        return service.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id){
        return service.setActiveStatus(id, false);
    }
}
