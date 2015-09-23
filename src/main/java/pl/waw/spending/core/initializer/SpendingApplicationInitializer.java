package pl.waw.spending.core.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pl.waw.spending.core.config.*;
import pl.waw.spending.core.config.security.OAuth2Config;
import pl.waw.spending.core.config.security.WebSecurityConfig;

//TODO: Rewrite to extends AbstractAnnotationConfigDispatcherServletInitializer
public class SpendingApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = createWebApplicationContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(context));
		addDispatcherServlet(servletContext, context);
		// Publish ContextStartedEvent
		context.refresh();
		context.start();

	}

	private AnnotationConfigWebApplicationContext createWebApplicationContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpendingApplicationConfig.class, PersistanceConfig.class, RepositoryConfig.class, WebConfig.class,
                WebSecurityConfig.class, OAuth2Config.class);
		context.setServletContext(servletContext);
		return context;
	}

	private void addDispatcherServlet(ServletContext servletContext, WebApplicationContext context) {
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
