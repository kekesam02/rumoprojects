package com.itbooking.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
public class ConnectionUtil {

    private ConnectionUtil(){}
    public static ConnectionUtil connectionUtil = null;
    public static ConnectionUtil getInstance(){
        if(connectionUtil==null){
            connectionUtil = new ConnectionUtil();
        }
        return connectionUtil;
    }

    public Connection getConnection() throws  Exception{
        //1.创建连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.189.130:61616");
        //2.获取连接
        Connection connection = connectionFactory.createConnection();
        return connection;
    }
}
