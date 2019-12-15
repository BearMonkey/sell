package org.monkey.sell.repository;

import org.monkey.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 根据商品状态查询商品信息
     * @param productStatus 商品状态
     * @return List<ProductInfo> 商品集合
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
