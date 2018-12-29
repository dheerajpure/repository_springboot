package dp.learn8.springbootjms01.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

//https://memorynotfound.com/spring-boot-activemq-queue-point-point-configuration-example/
@Service
public class MessageSender_Q1 {
	private static Logger log = LoggerFactory.getLogger(MessageSender_Q1.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendQueue(String msg) {
        log.info("sending with convertAndSend() to queue <" + msg + ">");
        //jmsTemplate.convertAndSend(ORDER_QUEUE, order);
    }

	


	
}
