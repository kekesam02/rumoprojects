package com.itbooking.core;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@SpringBootConfiguration
public class ActiveMQQueueConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("study.msg.queue") ;
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("study.msg.topic") ;
    }

    @Bean("saveItemTopic")
    public Topic saveItemTopic() {
        return new ActiveMQTopic("mq.staticindexcache.item.save") ;
    }

    @Bean("updateItemTopic")
    public Topic updateItemTopic() {
        return new ActiveMQTopic("mq.staticindexcache.item.update") ;
    }

    @Bean("deleteItemTopic")
    public Topic deleteItemTopic() {
        return new ActiveMQTopic("mq.staticindexcache.item.delete") ;
    }
}
