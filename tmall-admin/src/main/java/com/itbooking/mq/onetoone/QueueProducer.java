package com.itbooking.mq.onetoone;

import com.itbooking.mq.ConnectionUtil;
import org.apache.activemq.*;

import javax.jms.*;


/**
 * @Author 徐柯老师
 * @Description 发送消息
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
public class QueueProducer {


    public static void main(String[] args) {
        try {
            sendMessage();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*
     * @Author 徐柯老师
     * @Tel/微信：15074816437
     * @Description 发送消息类
     * @Date 17:40 2019/3/26
     * @Param []
     * @return void
     **/
    public static void sendMessage() throws  Exception{
        //1.获取连接
        Connection connection = ConnectionUtil.getInstance().getConnection();
        //2.启动连接
        connection.start();
        //3.获取session  (参数1：是否启动事务,参数2：消息确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建队列对象
        Queue queue = session.createQueue("test-queue");
        //5.创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //6.创建消息
        TextMessage textMessage = session.createTextMessage("欢迎来到神奇的电商购世界");
        //7.发送消息
        producer.send(textMessage);
        //8.关闭资源
        producer.close();
        session.close();
        connection.close();
    }

}
