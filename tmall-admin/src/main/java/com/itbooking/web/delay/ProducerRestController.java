package com.itbooking.web.delay;

import com.itbooking.core.ActiveManager;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.time.LocalDateTime;

/*
 * @Author 徐柯老师
 * @Tel/微信：15074816437
 * @Description
 * @Date 14:01 2019/3/27
 * @Param 
 * @return 
 **/
@RestController
@RequestMapping(value = "/test/producer", produces = "application/json")
public class ProducerRestController {
    /**
     * 注入ActiveManager
     */
    @Autowired
    ActiveManager activeManager;

    /**
     * 新增消息队列
     * http://localhost:9090/test/producer/add/queue
     */
    @RequestMapping(value = "/add/queue", method = RequestMethod.GET)
    public void addQueue() {
        Destination destination = new ActiveMQQueue("beyondLiQueueTest");
        //传入队列以及值
        activeManager.send(destination, "success");
    }

    /**
     * 新增消息队列(延迟)
     * http://localhost:9090/test/producer/add/delay/queue
     */
    @RequestMapping(value = "/add/delay/queue", method = RequestMethod.GET)
    public void addDelayQueue() {
        System.out.println(LocalDateTime.now());
        activeManager.delaySend("success", "beyondLiDelayQueueTest", 5000L);
    }


    /**
     * 新增消息队列
     * http://localhost:9090/test/producer/add/topic
     */
    @RequestMapping(value = "/add/topic", method = RequestMethod.GET)
    public void addTopic() {
        Destination destination = new ActiveMQTopic("beyondLiTopicTest");
        //传入队列以及值
        activeManager.send(destination, "success");
    }

    /**
     * 新增消息队列(延迟)
     * http://localhost:9090/test/producer/add/delay/topic
     */
    @RequestMapping(value = "/add/delay/topic", method = RequestMethod.GET)
    public void addDelayTopic() {
        System.out.println(LocalDateTime.now());
        activeManager.delaySendTopic("success", "beyondLiDelayTopicTest", 5000L);
    }
}
