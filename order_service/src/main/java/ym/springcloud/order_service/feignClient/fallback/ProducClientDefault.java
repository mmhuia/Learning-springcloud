package ym.springcloud.order_service.feignClient.fallback;

import org.springframework.stereotype.Component;
import ym.springcloud.order_service.domain.Product;
import ym.springcloud.order_service.feignClient.ProductClient;

/**
 * @author ym
 * @desc
 * @since 2018/11/27-10:56
 */
@Component
public class ProducClientDefault implements ProductClient {
    @Override
    public Product findById(Long id) {
        System.out.println("findById 调用失败，抛出异常！跳转到ProducClientDefault");
        Product p = new Product();
        p.setId(1L);
        p.setName("fallback; reason was: unknow");
        return p;
    }
}
