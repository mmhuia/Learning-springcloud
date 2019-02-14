package ym.springcloud.api_gateway.preFilter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ym
 * @desc
 * @since 2018/12/24-18:14
 */
@Component
public class SaveOrderRateLimiterFilter extends ZuulFilter {

    private final RateLimiter RATE_LIMITER = RateLimiter.create(1);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        if(request.getRequestURI().indexOf("/order/saveOrder") != -1){

            if(!RATE_LIMITER.tryAcquire()){
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                System.out.println("限流");
            }

        }

        System.out.println("正常通行");
        return null;
    }
}
