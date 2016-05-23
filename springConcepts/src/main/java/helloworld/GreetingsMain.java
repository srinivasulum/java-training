package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsMain {
	
	private static Logger logger = LoggerFactory.getLogger(GreetingsMain.class);

	public static void main(String[] args)
	{

		ApplicationContext appCtx = new ClassPathXmlApplicationContext("helloworld/spring-helloworld-config.xml");
		
		Greetings bean = appCtx.getBean("Greetings", Greetings.class);
		
		logger.info(bean.pleaseGreet());
		
		((ClassPathXmlApplicationContext) appCtx).close();
		
	}

}
