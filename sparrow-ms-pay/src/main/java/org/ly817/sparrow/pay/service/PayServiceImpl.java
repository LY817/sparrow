package org.ly817.sparrow.pay.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.service.IPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/08/21 16:22
 * <p>
 * Description:
 */
@RestController
public class PayServiceImpl implements IPayService {

    private final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);

    @Override
    public String payCheck(String payToken, Double amount) throws APIException {
        logger.error(payToken);
        return null;
    }

    @Override
    public String payCallback() throws APIException {
        return null;
    }
}
