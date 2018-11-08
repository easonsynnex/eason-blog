package com.eason.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.eason.payService.config.AlipayConfig;
import com.eason.payService.entity.Orders;
import com.eason.payService.entity.Product;
import com.eason.payService.pay.AliPay;
import com.eason.utils.IdWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
@RequestMapping("/alipay")
public class PayController {
    private static final Logger log = LogManager.getLogger(PayController.class);

    @Autowired
    AliPay pay;

    @RequestMapping(value = "/goPay",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String goPay() throws Exception{
        Orders order = new Orders();
        order.setId("1");
        order.setBuyCounts(1);
        order.setOrderNum(String.valueOf(IdWorker.idWorker.nextId()));
        order.setOrderStatus("10");
        order.setOrderAmount("20");
        order.setPaidAmount(null);
        order.setCreateTime(new Date());
        order.setProductId("1");

        Product product = new Product();
        product.setId("1");
        product.setName("iPhone X");
        product.setPrice("6666");

        String html = pay.doPay(order,product);

        return html;
    }

    @RequestMapping(value = "/alipayReturnNotice")
    public ModelAndView alipayReturnNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {
        log.info("支付成功，进入同步通知接口...");
        ModelAndView mv = pay.syncNotice(request,response);

        return mv;
    }

    /**
     * @Description: 支付宝异步 通知页面
     */
    @RequestMapping(value = "/alipayNotifyNotice",method = {RequestMethod.POST,RequestMethod.GET})
    public String alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {

        log.info("支付成功, 进入异步通知接口...");

        pay.nonSyncNotice(request,response);

        return "success";
    }

}
