package org.monkey.sell.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monkey.sell.dataobject.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    // 测试插入操作
    @Test
    public void saveOneTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 3);
        ProductCategory result = repository.save(productCategory);
        
        // Assert: 断言
        // Assert.assertNotEquals:
        //   arg1: 不期望的值
        //   arg2: 实际的值
        Assert.assertNotEquals(null, result);
        
    }
    
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
    

}
