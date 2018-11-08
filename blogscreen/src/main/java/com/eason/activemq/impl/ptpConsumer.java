package com.eason.activemq.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by easony on 06/27/18.
 */
//@Service
public class ptpConsumer {

    @JmsListener(destination = "activemq-queue")
    public void recieveQueue(String msg){
        System.out.println("Consumer-queue收到消息："+msg);
    }

    @JmsListener(destination = "activemq-queue")
    public void logQueue(String msg){
        System.out.println("Consumer-log-queue收到消息："+msg);
    }

    @JmsListener(destination = "activemq-topic")
    public void recieveTopic(String msg){
        System.out.println("Consumer-topic收到消息："+msg);
    }
}
