package com.itbooking.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 
 * 
 * CustomerRest<br/>
 * 创建人:xuchengfeifei<br/>
 * 时间：2019年3月27日-下午2:02:36 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CustomerRest {

    /**
     * 监听方
     */
    //监听注解
    @JmsListener(destination = "beyondLiQueueTest")
    public void getQueue(String info) {
        System.out.println("成功监听beyondLiQueue消息队列，传来的值为:" + info);
    }

    //
    @JmsListener(destination = "beyondLiDelayQueueTest")
    public void getDelayQueue(String info) {
        System.out.println("成功监听beyondLiQueueTest消息队列，传来的值为:" + info + "当前时间为" + LocalDateTime.now());
    }

    /**
     * 监听方
     */
    //监听注解
    @JmsListener(destination = "beyondLiTopicTest")
    public void getTopic(String info) {
        System.out.println("topic------------>成功监听beyondLiTopicTest消息队列，传来的值为:" + info);
    }

    //
    @JmsListener(destination = "beyondLiDelayTopicTest")
    public void getDelayTopic(String info) {
        System.out.println("topic------------>成功监听beyondLiDelayTopicTest消息队列，传来的值为:" + info + "当前时间为" + LocalDateTime.now());
    }
}