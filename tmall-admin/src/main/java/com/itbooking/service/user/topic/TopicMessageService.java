package com.itbooking.service.user.topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Topic;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@Service
public class TopicMessageService  implements  IMessageTopicProducerService{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @Override
    public void sendMessage(String msg) {
        // 构建一个消息, 名称是 queue01
        String message = "我是消息内容, " +msg+ System.currentTimeMillis();
        this.jmsMessagingTemplate.convertAndSend(topic, message);
//        Destination destination = new ActiveMQTopic("study.msg.topic");
//        String message = "我是消息内容, " +msg+ System.currentTimeMillis();
//        this.jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
