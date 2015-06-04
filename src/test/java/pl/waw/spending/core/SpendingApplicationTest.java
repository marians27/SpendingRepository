package pl.waw.spending.core;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import pl.waw.spending.core.SpendingApplication;

public class SpendingApplicationTest {

	@Test
	public void verifyIfConfigurationAvailable() {
		Assert.assertNotNull(SpendingApplication.INSTANCE.getContext());
	}
	
	@Test
	public void verifyDataSourceAvailable() {
		ApplicationContext context = SpendingApplication.INSTANCE.getContext();
		DataSource dataSource = context.getBean(DataSource.class);
		Assert.assertNotNull(dataSource);
	}
	
	@Test
	public void verifySessionFactoryAvailable() {
		ApplicationContext context = SpendingApplication.INSTANCE.getContext();
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		Assert.assertNotNull(sessionFactory);
	}
}
