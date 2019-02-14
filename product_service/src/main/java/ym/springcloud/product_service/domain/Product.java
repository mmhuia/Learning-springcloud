package ym.springcloud.product_service.domain;

import java.io.Serializable;

/**
 * @author ym
 * @desc
 * @since 2018/11/6-15:23
 */
public class Product implements Serializable{

    private Long id;

    private String name;

    public Product() {
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
