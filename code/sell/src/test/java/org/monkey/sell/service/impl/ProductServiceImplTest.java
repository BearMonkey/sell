package org.monkey.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monkey.sell.dataobject.ProductInfo;
import org.monkey.sell.enums.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    
    @Autowired
    private ProductServiceImpl productService;
    
    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("123456");
        Assert.assertEquals("123456", result.getProductId());
    }
    
    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }
    
    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }
    
    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("白粥");
        productInfo.setProductPrice(new BigDecimal(2));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("要加一点豆角");
        productInfo.setProductIcon("https://192.168.1.106/白粥.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}
