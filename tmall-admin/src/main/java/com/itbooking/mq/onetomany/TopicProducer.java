package com.itbooking.mq.onetomany;

import com.itbooking.mq.ConnectionUtil;
import org.apache.activemq.*;

import javax.jms.*;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
public class TopicProducer {

    public static void main(String[] args) {
        try {
            sendMessage();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void sendMessage() throws  Exception{
        //1.创建连接工厂
        //2.获取连接
        Connection connection = ConnectionUtil.getInstance().getConnection();
        //3.启动连接
        connection.start();
        //4.获取session  (参数1：是否启动事务,参数2：消息确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建主题对象
        Topic topic = session.createTopic("test-topic");
        //6.创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        //7.创建消息
        TextMessage textMessage = session.createTextMessage("欢迎来到神奇的电商购世界");
        //8.发送消息
        producer.send(textMessage);
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
