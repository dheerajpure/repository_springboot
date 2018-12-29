package dp.learn8.springbootjms01;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;

import dp.learn8.springbootjms01.file.FileReader;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("dp.learn8.springbootjms01")
@ImportResource({"classpath*:springContext.xml"})
@PropertySource("classpath:application.properties")
public class SpringBootJms01Application {

	public static void main(String[] args) throws IOException {
   	 ConfigurableApplicationContext context = SpringApplication.run(SpringBootJms01Application.class, args);
   	 new FileReader().readFiles(context.getBean(JmsTemplate.class));
   	 /*
   	 JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
   	 System.out.println("Sending an message.");
   	 jmsTemplate.convertAndSend(Constant.QUEUE_01,"this is test msg");
		//SpringApplication.run(SpringBootJms01Application.class, args);
   	 */
   //	context.close();
   	
	}
}
