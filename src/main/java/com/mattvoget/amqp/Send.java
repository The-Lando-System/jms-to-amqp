package com.mattvoget.amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

  private final static String QUEUE_NAME = "my-queue";
  private final static String HOST = "localhost";
  private final static int PORT = 9191;
  
  public Send() {}
  
  public void sendAmqpMessage(String message){
	try {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclarePassive(QUEUE_NAME);
		//channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		//String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	} catch (Exception e){
		e.printStackTrace();
	}
  }
}