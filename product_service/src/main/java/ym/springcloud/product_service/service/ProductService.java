package ym.springcloud.product_service.service;

import ym.springcloud.product_service.domain.Product;

import java.util.List;

/**
 * @author ym
 * @desc
 * @since 2018/11/6-15:23
 */
public interface ProductService {

    List<Product> listProduct();

    Product findById(Long id);
}
