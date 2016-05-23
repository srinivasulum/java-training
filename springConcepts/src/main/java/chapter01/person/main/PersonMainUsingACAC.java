package chapter01.person.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter01.person.config.AppConfig;
import chapter01.person.service.PersonManager;

//Boot straping using AnnotationConfigApplicationContext

// No need of XML to specify component scanning
public class PersonMainUsingACAC {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx =
			     new AnnotationConfigApplicationContext();
			 ctx.register(AppConfig.class);
			 ctx.refresh();

			 PersonManager bean = ctx.getBean(PersonManager.class);
			 
			 bean.printAll();
	}
	

}
