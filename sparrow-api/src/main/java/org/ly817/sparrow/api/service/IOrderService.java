package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;

import org.ly817.sparrow.api.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 */
//@RequestMapping
@FeignClient(value = "sparrow-ms-order")
public interface IOrderService {

    /**
     * �ύ����
     * �����ύ��֧���������첽���е�
     *
     *
     * - У�鶩��
     *   - У�����Ƿ��㹻
     *   - У�鹺��ȯ�Ƿ����
     *   - У����:��֤ǰ�˼���Ľ��
     * - ����Ԥ����
     *   - �����
     *   - ���Ϲ���ȯ
     *   - ���ɼ�¼������
     *   - todo *֪ͨ�̻�
     *
     *
     *
     * - ���ø���ӿ�
     *   - ���óɹ�
     *     - �޸Ķ���״̬
     *     - �ӻ���
     *     - ����
     *     - ֪ͨ�ͻ���
     *   - ����ʧ��
     *     - �ع���桢����ȯ
     *
     * ����Ԥ���쳣
     * - ������ó�ʱ���µ����ݲ�һ��
     * - ������ӿڵ��ݵ���
     *
     * @param order
     */
    @PostMapping("orders")
    Order addPreOrder(@RequestBody Order order);

    /**
     * ȷ�϶���
     * ֧���ɹ� ��Ԥ����״̬�Ķ������и���Ϊ��֧�� ������������Լ����
     *
     * @param order
     */
    @PatchMapping("orders/confirm")
    Order confirmPreOrder(@RequestBody Order order);

    /**
     * ȡ������
     *
     * �µ���֧���ֿ�
     * �����µ�֮����һ������ʱ����Ҫ�ڵ���ʱ����֮ǰ���֧�����������򶩵��ᱻȡ��
     * @param order
     */
    @PatchMapping("orders/rollback")
    Order rollbackPreOrder(@RequestBody Order order);
}
