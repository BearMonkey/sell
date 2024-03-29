package org.monkey.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品
 * product_category
 */
@Table(name = "product_info")
@Entity
@Data
public class ProductInfo {

        @Id
        private String productId;
        /** 商品名称 */
        private String productName;
        /** 单价 */
        private BigDecimal productPrice;
        /** 库存 */
        private Integer productStock;
        /** 描述 */
        private String productDescription;
        /** 小图 */
        private String productIcon;
        /** 商品状态，0：正常，1：下架*/
        private Integer productStatus;
        /** 类目编号 */
        private Integer categoryType;
}
