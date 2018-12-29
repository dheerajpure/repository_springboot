package dp.learn8.springbootjms01.receiver;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dp.learn8.springbootjms01.Constant;

@Component
public class MessageReceiver_Q1 {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@JmsListener(destination = Constant.QUEUE_01)
	public void receiveMessage(@Payload String msg, @Headers MessageHeaders headers, Session session) {
		System.out.println("==> receieve msg : "+msg);
		String msg2 = messageTransformation(msg);
		System.out.println("receiveMessage msg2 "+msg2);
		messageSender2NextQueue(msg2);
	}

	/**
	 * Message transformation
	 * @param msg
	 * @return
	 */
	private String messageTransformation(String msg) {
		System.out.println("messageTransformation msg2 "+msg);
		return msg;
	}
	
	/**
	 * MessageSendto next Queue
	 * @param msg
	 */
	private void messageSender2NextQueue(String msg) {
		System.out.println("messageTransformation msg "+msg);
		jmsTemplate.convertAndSend(Constant.QUEUE_02,msg);
	}


	
}
