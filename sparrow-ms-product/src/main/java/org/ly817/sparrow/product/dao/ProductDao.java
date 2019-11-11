package org.ly817.sparrow.product.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ly817.sparrow.api.pojo.Product;
import org.ly817.sparrow.api.pojo.ProductExample;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Long productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Long productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int updateInventoryByProductId(@Param("productId") Long productId,@Param("number") Integer number);
}