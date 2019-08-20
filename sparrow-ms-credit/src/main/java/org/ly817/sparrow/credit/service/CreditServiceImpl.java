package org.ly817.sparrow.credit.service;

import org.ly817.sparrow.api.dto.APIResponse;
import org.ly817.sparrow.api.enums.APIExceptionType;
import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Product;
import org.ly817.sparrow.api.service.ICreditService;
import org.ly817.sparrow.api.service.IInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/08/14 16:32
 * <p>
 * Description:
 * 库存微服务实现
 */
@RestController
public class CreditServiceImpl implements ICreditService {

    private final Logger logger = LoggerFactory.getLogger(CreditServiceImpl.class);

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void addCreditScore(@PathVariable("userId") Long userId,@PathVariable("score") int score) throws APIException {
        logger.info("");
    }
}
