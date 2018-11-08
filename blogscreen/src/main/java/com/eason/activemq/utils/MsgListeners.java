package com.eason.activemq.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by easony on 06/27/18.
 */
@Configuration
@EnableJms
public class MsgListeners {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("activemq-queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("activemq-topic");
    }
}
