package org.monkey.sell.service.impl;

import org.monkey.sell.dataobject.ProductCategory;
import org.monkey.sell.repository.ProductCategoryRepository;
import org.monkey.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private ProductCategoryRepository repository;
    
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }
    
    @Override
    public List<ProductCategory> finaAll() {
        return repository.findAll();
    }
    
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }
    
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
