package org.monkey.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monkey.sell.dataobject.ProductCategory;
import org.monkey.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceImplTest {
    
    @Autowired
    private CategoryServiceImpl categoryService;
    
    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }
    
    @Test
    public void finaAll() {
        List<ProductCategory> productCategoryList = categoryService.finaAll();
        Assert.assertNotEquals(0, categoryService.finaAll().size());
    }
    
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0, categoryService.finaAll().size());
    }
    
    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("男人堂", 4);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}
