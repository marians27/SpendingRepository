package pl.waw.spending.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public enum SpendingApplication {

	INSTANCE;
	
	private final ApplicationContext context;
	
	private SpendingApplication() {
		AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext("pl.waw.spending");
		context = rootContext;
	}
	
	public ApplicationContext getContext() {
		return context;
	}
	
}
