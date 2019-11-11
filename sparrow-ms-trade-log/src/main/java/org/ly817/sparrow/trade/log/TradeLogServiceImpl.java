package org.ly817.sparrow.trade.log;

import org.ly817.sparrow.api.pojo.OrderProductLog;
import org.ly817.sparrow.api.pojo.OrderUserBalanceLog;
import org.ly817.sparrow.api.service.ITradeLogService;
import org.ly817.sparrow.trade.log.dao.OrderProductLogDao;
import org.ly817.sparrow.trade.log.dao.OrderUserBalanceLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/11/10 19:11
 * <p>
 * Description:
 */
@RestController
public class TradeLogServiceImpl implements ITradeLogService {

    @Autowired
    private OrderProductLogDao orderProductLogDao;

    @Autowired
    private OrderUserBalanceLogDao orderUserBalanceLogDao;

    @Override
    public int addOrderProductLog(@RequestBody OrderProductLog orderProductLog) {
        return orderProductLogDao.insert(orderProductLog);
    }

    @Override
    public int addOrderUserBalanceLog(@RequestBody OrderUserBalanceLog orderUserBalanceLog) {
        return orderUserBalanceLogDao.insert(orderUserBalanceLog);
    }

}
