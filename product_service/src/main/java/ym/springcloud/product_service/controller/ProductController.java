package ym.springcloud.product_service.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ym.springcloud.product_service.domain.Product;
import ym.springcloud.product_service.service.ProductService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ym
 * @desc
 * @since 2018/11/6-15:23
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("/listProduct")
    List<Product> listProduct() {
        return productService.listProduct();
    }

    @RequestMapping("/findById")
    Product findById(Long id) {
        System.out.println("findById id["+id+"]");
        if(id == 0L){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product p1 = productService.findById(id);
        Product p2 = new Product();
        BeanUtils.copyProperties(p1, p2);
        p2.setName(port);
        return p2;
    }

}
