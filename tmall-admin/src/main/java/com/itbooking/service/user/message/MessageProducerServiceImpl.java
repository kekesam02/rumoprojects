package com.itbooking.service.user.message;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void sendMessage(String msg) {
        String message = "我是消息内容, " +msg+ System.currentTimeMillis();
        // 构建一个消息, 名称是 queue01
        //Destination destination = new ActiveMQQueue("study.msg.queue");
        //this.jmsMessagingTemplate.convertAndSend(destination, message);
        this.jmsMessagingTemplate.convertAndSend(queue, message);
    }

    @Scheduled(fixedDelay=3000)//每3s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }

}