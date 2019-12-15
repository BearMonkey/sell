package org.monkey.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.monkey.sell.VO.ProductInfoVO;
import org.monkey.sell.VO.ProductVO;
import org.monkey.sell.VO.ResultVO;
import org.monkey.sell.dataobject.ProductCategory;
import org.monkey.sell.dataobject.ProductInfo;
import org.monkey.sell.service.CategoryService;
import org.monkey.sell.service.ProductService;
import org.monkey.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/list")
    public ResultVO list() {
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        
        // 2.查询类目(一次性查询)
        // 传统方式
        /*List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        // lambda表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
            
        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            // foods
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (!productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    continue;
                }
                ProductInfoVO productInfoVO = new ProductInfoVO();
                
                // 1.传统方式，一条一条set
                /*productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVO.setProductPrice(productInfo.getProductPrice());
                productInfoVO.setProductDescription(productInfo.getProductDescription());
                productInfoVO.setProductIcon(productInfo.getProductIcon());*/
                
                // 2.Spring的工具类BeanUtils, BeanUtils.copyProperties(arg1, arg2) 从arg1拷贝到arg2
                BeanUtils.copyProperties(productInfo, productInfoVO);
                
                productInfoVOList.add(productInfoVO);
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        log.info(productVOList.toString());
        return ResultVOUtil.success(productVOList);
    }
}
