package com.eason.controller;

import com.eason.activemq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by easony on 06/27/18.
 */
@RestController
@RequestMapping("/activeMq")
public class ActiveMqController {
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private MessageService productService;

    @GetMapping("/queue/{msg}")
    public void sendQueue(@PathVariable("msg") String msg){
        productService.sendMsg(this.queue,msg);
    }

    @GetMapping("/topic/{msg}")
    public void sendTopic(@PathVariable("msg")String msg){
        productService.sendMsg(this.topic,msg);
    }
}