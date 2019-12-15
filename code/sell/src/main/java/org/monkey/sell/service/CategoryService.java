package org.monkey.sell.service;

import org.monkey.sell.dataobject.ProductCategory;

import java.util.List;

/**
 *
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    
    List<ProductCategory> finaAll();
    
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    
    ProductCategory save(ProductCategory productCategory);
}
