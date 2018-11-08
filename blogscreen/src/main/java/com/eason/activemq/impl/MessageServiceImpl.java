package com.eason.activemq.impl;

import com.eason.activemq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Created by easony on 06/27/18.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
