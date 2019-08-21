package org.ly817.sparrow.api.model;

import java.io.Serializable;

/**
 * @author LuoYu
 * @date 2019/06/06 9:21
 * <p>
 * Description:
 */
public class Product  implements Serializable {
    private String productId;

    private String productName;

//    private Long prodCompanyId;

    /**
     * 单价
     */
    private Double price;

    /**
     * 库存
     */
    private Long inventory;

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public Long getProdCompanyId() {
//        return prodCompanyId;
//    }

//    public void setProdCompanyId(Long prodCompanyId) {
//        this.prodCompanyId = prodCompanyId;
//    }
}
