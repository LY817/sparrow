package org.ly817.sparrow.api.model;

/**
 * @author LuoYu
 * @date 2019/06/06 9:21
 * <p>
 * Description:
 */
public class Product {
    private Long productId;

    private String productName;

    private Long prodCompanyId;

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

    public Long getProdCompanyId() {
        return prodCompanyId;
    }

    public void setProdCompanyId(Long prodCompanyId) {
        this.prodCompanyId = prodCompanyId;
    }
}
