package chapter01.person.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter01.person.domain.Person;
import chapter01.person.service.PersonManager;

public class PersonMain {
	
	private static Logger logger = LoggerFactory.getLogger(PersonMain.class);
	
	public static void main(String[] args)
	{
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("person/spring-person-config.xml");
		
		PersonManager bean = appCtx.getBean("personService", PersonManager.class);
		
		logger.info("************************************");
		bean.printAll();
		
		bean.create(new Person("Srinivasulu", "Mudduluru", "02-07-1982"));
		
		logger.info("************************************");
		bean.printAll();
		
		((ClassPathXmlApplicationContext) appCtx).close();

	}

}
