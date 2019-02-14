package ym.springcloud.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ym.springcloud.order_service.domain.Product;
import ym.springcloud.order_service.service.OrderService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ym
 * @desc
 * @since 2018/11/16-10:56
 */
@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${profile}")
    private String profile;

    @RequestMapping("/saveOrder")
    @HystrixCommand(fallbackMethod = "defaultSaveOrder")
    public Object saveOrder(HttpServletRequest request, Long userId){
        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");
        System.out.println("token: " + token);
        System.out.println("Cookie: " + cookie);
        System.out.println("profile: " + profile);


        return orderService.saveOrder(userId);
    }

    public Object defaultSaveOrder(HttpServletRequest request, Long userId) {
        Product p = new Product();
        p.setName("人数太多，请稍后再试");
        p.setId(1L);
        return p;
    }
}
