package com.itbooking.mq.onetoone;
import com.itbooking.mq.ConnectionUtil;
import com.itbooking.pojo.User;
import org.apache.activemq.*;
import sun.applet.Main;

import javax.jms.*;
import javax.jms.Message;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
public class QueueConsumer {

    public static void main(String[] args) {
        try {
            recevice();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*
     * @Author 徐柯老师
     * @Tel/微信：15074816437
     * @Description 接收消息
     * @Date 17:40 2019/3/26
     * @Param []
     * @return void
     **/
    public static void recevice() throws  Exception{
        //1.获取连接
        Connection connection = ConnectionUtil.getInstance().getConnection();
        //2.启动连接
        connection.start();
        //3.获取session  (参数1：是否启动事务,参数2：消息确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建队列对象
        Queue queue = session.createQueue("test-queue");
        //5.创建消息消费
        MessageConsumer consumer = session.createConsumer(queue);
        //6.监听消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage=(TextMessage)message;
                try {
                    System.out.println("接收到消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //7.等待键盘输入
        System.in.read();
        //8.关闭资源
        consumer.close();
        session.close();
        connection.close();
    }


}
