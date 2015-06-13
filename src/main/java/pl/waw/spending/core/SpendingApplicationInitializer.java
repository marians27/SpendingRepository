package pl.waw.spending.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pl.waw.spending.core.config.PersistanceConfig;
import pl.waw.spending.core.config.WebConfig;

public class SpendingApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = createWebApplicationContext(servletContext);
		addDispatcherServlet(servletContext, context);
		SpendingApplication.setSpendingApplicationContext(context);
		
	}

	private WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(PersistanceConfig.class, WebConfig.class);
		context.setServletContext(servletContext);
		return context;
	}

	private void addDispatcherServlet(ServletContext servletContext, WebApplicationContext context) {
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
