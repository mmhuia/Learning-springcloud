package ym.springcloud.order_service.feignClient.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import ym.springcloud.order_service.domain.Product;
import ym.springcloud.order_service.feignClient.ProductClient;

/**
 * @author ym
 * @desc
 * @since 2018/11/27-11:14
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<ProductClient> {


    @Override
    public ProductClient create(Throwable throwable) {
        return new ProductClient() {
            @Override
            public Product findById(Long id) {
                System.out.println("findById 调用失败，抛出异常！跳转到HystrixClientFallbackFactory");
                Product p = new Product();
                p.setId(1L);
                p.setName("fallback; reason was: " + throwable.getMessage());
                return p;
            }
        };
    }
}
