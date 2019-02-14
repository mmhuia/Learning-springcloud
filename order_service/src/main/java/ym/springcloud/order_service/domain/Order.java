package ym.springcloud.order_service.domain;

/**
 * @author ym
 * @desc
 * @since 2018/11/16-10:54
 */
public class Order {

    private Long orderId;

    private String orderName;

    private Long productId;

    private String productName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
