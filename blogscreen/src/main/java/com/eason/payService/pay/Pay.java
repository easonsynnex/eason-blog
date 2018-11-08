package com.eason.payService.pay;

import com.alipay.api.AlipayApiException;
import com.eason.payService.entity.Orders;
import com.eason.payService.entity.Product;

public interface Pay {
    void prePay(Orders order, Product product);
    String doPay(Orders order, Product product) throws AlipayApiException;
    void afterPay(Orders order, Product product);
}
