package com.mattvoget.amqp;

public class QueueBridge {
	
	public static void main(String[] argv) throws Exception {
		
		RecvJms jmsReceiver = new RecvJms();
		Send amqpSender = new Send();
		
		amqpSender.sendAmqpMessage(jmsReceiver.getMessage());
		//amqpSender.sendAmqpMessage("Testing");
	}
	
}