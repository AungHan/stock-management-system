package com.aunghan.stockmanagementsystem.service;

import com.aunghan.stockmanagementsystem.entity.Category;
import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    List<Category> getCategories();

    Category getCategoryById(int id);

    Category getCategoryByCategoryName(String categoryName);

    String deleteCategory(int id);

    Category updateCategory(Category category);

    String setActiveStatus(int id, boolean isActive);
}
