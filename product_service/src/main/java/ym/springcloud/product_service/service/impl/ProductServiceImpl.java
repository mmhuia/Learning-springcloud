package ym.springcloud.product_service.service.impl;

import org.springframework.stereotype.Service;
import ym.springcloud.product_service.domain.Product;
import ym.springcloud.product_service.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ym
 * @desc
 * @since 2018/11/6-15:23
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Long, Product> map = new HashMap<>();

    static {
        Product p0 = new Product(0L, "caca");
        Product p1 = new Product(1L, "wow");
        Product p2 = new Product(2L, "cat");
        Product p3 = new Product(3L, "doge");
        Product p4 = new Product(4L, "sniper");

        map.put(p0.getId(), p0);
        map.put(p1.getId(), p1);
        map.put(p2.getId(), p2);
        map.put(p3.getId(), p3);
        map.put(p4.getId(), p4);
    }

    @Override
    public List<Product> listProduct() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product findById(Long id) {
        return map.get(id);
    }
}
