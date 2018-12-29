package dp.learn8.springbootjms01.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import dp.learn8.springbootjms01.Constant;

@Component
public class FileReader {
	
	
/*	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader();
		fr.readFiles();
	}*/

	public void readFiles(JmsTemplate jmsTemplate) throws IOException {
		byte[] encoded = null;
		
		File[] files = new File(Constant.INPUT_FILE_PATH).listFiles();
		
		for(File file : files){
			try {
				encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
				 System.out.println( new String(encoded));
				 jmsTemplate.convertAndSend(Constant.QUEUE_01,new String(encoded));
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	
}
