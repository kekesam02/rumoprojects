package com.itbooking.mq.onetomany;
import com.itbooking.mq.ConnectionUtil;
import org.apache.activemq.*;

import javax.jms.*;
import javax.jms.Message;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
public class TopicConsumer01 {

    public static void main(String[] args) {
        try {
            recevice();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void recevice() throws  Exception{
        //1.创建连接工厂
        //2.获取连接
        Connection connection = ConnectionUtil.getInstance().getConnection();
        //3.启动连接
        connection.start();
        //4.获取session  (参数1：是否启动事务,参数2：消息确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建主题对象
        //Queue queue = session.createQueue("test-queue");
        Topic topic = session.createTopic("test-topic");
        //6.创建消息消费
        MessageConsumer consumer = session.createConsumer(topic);
        //7.监听消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage=(TextMessage)message;
                try {
                    System.out.println("topic1----------->接收到消息："+textMessage.getText());
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //8.等待键盘输入
        System.in.read();
        //9.关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
