package ym.springcloud.order_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ym.springcloud.order_service.domain.Product;
import ym.springcloud.order_service.feignClient.ProductClient;
import ym.springcloud.order_service.service.OrderService;

/**
 * @author ym
 * @desc
 * @since 2018/11/16-10:55
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Value("${server.port}")
    private String port;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object saveOrder(Long userId) {
//        Object obj = restTemplate.getForObject("http://product-service/product/findById?id=1", Object.class);
//        System.out.println(obj);
//        return obj;
        Product product = productClient.findById(userId);
        return product;
    }



}
