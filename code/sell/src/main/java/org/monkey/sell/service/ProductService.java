package org.monkey.sell.service;

import org.monkey.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 */
public interface ProductService {
    /**
     * 按照id查询
     * @param productId 商品id
     * @return 商品信息
     */
    ProductInfo findOne(String productId);
    
    /**
     * 查询所有商品
     * @param pageable 分页信息
     * @return 商品列表
     */
    Page<ProductInfo> findAll(Pageable pageable);
    
    /**
     * 查询已上架商品
     * @return 商品列表
     */
    List<ProductInfo> findUpAll();
    
    /**
     * 增加商品
     * @param productInfo 商品信息
     * @return 商品信息
     */
    ProductInfo save(ProductInfo productInfo);
    
    // 加库存
    
    // 减库存
    
}
