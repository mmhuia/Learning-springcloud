package ym.springcloud.order_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ym.springcloud.order_service.domain.Product;
import ym.springcloud.order_service.feignClient.fallback.ProducClientDefault;

/**
 * @author ym
 * @desc
 * @since 2018/11/20-16:34
 */
@FeignClient(
        value = "product-service",
        //fallbackFactory = HystrixClientFallbackFactory.class,
        fallback = ProducClientDefault.class)
public interface ProductClient {

    @RequestMapping("/product/findById")
    Product findById(@RequestParam(value = "id") Long id);
}
