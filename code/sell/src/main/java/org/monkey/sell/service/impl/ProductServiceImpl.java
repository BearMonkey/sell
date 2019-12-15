package org.monkey.sell.service.impl;

import org.monkey.sell.dataobject.ProductInfo;
import org.monkey.sell.enums.ProductStatusEnum;
import org.monkey.sell.repository.ProductInfoRepository;
import org.monkey.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductInfoRepository repository;
    
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }
    
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
    
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
