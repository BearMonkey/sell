package org.monkey.sell.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monkey.sell.dataobject.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterRepositoryTest {
    
    @Autowired
    private OrderMasterRepository repository;
    
    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2019120403");
        orderMaster.setBuyerName("李先生");
        orderMaster.setBuyerPhone("13751172435");
        orderMaster.setBuyerAddress("关外");
        orderMaster.setBuyerOpenid("110112");
        orderMaster.setOrderAmount(new BigDecimal(2.0));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 1);
    
        Page<OrderMaster> result = repository.findByBuyerOpenid("110110", request);
    }
}
