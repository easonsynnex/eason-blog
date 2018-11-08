package com.eason.activemq;

import javax.jms.Destination;

/**
 * Created by easony on 06/27/18.
 */
public interface MessageService {
    void sendMsg(Destination destination, String message);
}
