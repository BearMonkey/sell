package org.monkey.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * product_category
 */
@Table(name = "product_category")    // 指定表名，适用于表名和类名规则不匹配的情况
@Entity        //  实体类
@DynamicUpdate //时间自动更新
@Data          //可以省略getter setter toString等方法，这些代码会在编译时自动生成，不会影响最终运行时的性能，省略开发的工作量
public class ProductCategory {
    @Id        //主键
    @GeneratedValue  // 生成策略： 自增
    private Integer categoryId;
    /** 类目名字 */
    @Column(name = "category_name")
    private String categoryName;
    /** 类目编号 */
    @Column(name = "category_type")
    private Integer categoryType;
    
    /**
     * 默认构造方法
     */
    public ProductCategory() {
    }
    
    /**
     * 指定name和type的构造方法
     * @param categoryName name
     * @param categoryType type
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
