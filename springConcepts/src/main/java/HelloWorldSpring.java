import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldSpring {

	private static Logger logger = LoggerFactory.getLogger(HelloWorldSpring.class);
	
	public static void main(String args[])
	{
		logger.info("Loading spring configuration file");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		HelloWorld bean = ctx.getBean("helloWorld", HelloWorld.class);
		
		System.out.println(bean.getMessage());
	}

}
