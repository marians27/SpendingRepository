package pl.waw.spending.core;

import org.springframework.context.ApplicationContext;

public class SpendingApplication {
	
	private static ApplicationContext context;
	
	static void setSpendingApplicationContext(ApplicationContext context) {
		SpendingApplication.context = context;
	}
	
	public static ApplicationContext getContext() {
		return SpendingApplication.context;
	}
	
}
