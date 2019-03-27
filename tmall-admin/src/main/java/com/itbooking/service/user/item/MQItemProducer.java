package com.itbooking.service.user.item;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@Component
public class MQItemProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name="saveItemTopic")
    private Topic saveItemTopic;
    @Resource(name="updateItemTopic")
    private Topic updateItemTopic;
    @Resource(name="deleteItemTopic")
    private Topic deleteItemTopic;

    // 发送静态化消息 和 发送索引化处理 以及缓存改写
    public void staticIndexCacheSend(String itemJson){
        jmsMessagingTemplate.convertAndSend(saveItemTopic,itemJson);
    }

    // 发送静态化消息 和 发送索引化处理 以及缓存改写
    public void staticIndexCacheSendUpdate(String itemJson){
        jmsMessagingTemplate.convertAndSend( updateItemTopic,itemJson);
    }

    // 发送静态化消息 和 发送索引化处理 以及缓存改写
    public void staticIndexCacheSenddelete(String itemJson){
        jmsMessagingTemplate.convertAndSend(deleteItemTopic,itemJson);
    }

}
