package com.itbooking.service.user.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {


    @JmsListener(destination="study.msg.queue")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.out.println("【queue1------------>*** 接收消息 ***】" + text);
    }

    @JmsListener(destination="study.msg.topic")
    public void receiveTopicMessage(String text) {    // 进行消息接收处理
        System.out.println("【topic1-------->*** 接收消息 ***】" + text);
    }

}