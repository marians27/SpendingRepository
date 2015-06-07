package pl.waw.spending.core;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.waw.spending.core.config.PersistanceConfig;
import pl.waw.spending.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
	classes={PersistanceConfig.class}, 
	loader=AnnotationConfigContextLoader.class)
public class PersistenceConfigTest {
	
	@Autowired
    private ApplicationContext context;
	
	private List<Long> createdCategoryIds;
	
	@Before
	public void prepareTestData() {
		createdCategoryIds = new ArrayList<Long>();
	}
	
	@After
	public void cleanupAfterTests() {
		for(Long id : createdCategoryIds) {
			deleteCategory(id);
		}
	}
	
	@Test
	public void verifyHibernateConfiguration() {
		int initialSize = getCategorySize();
		long id = createNewCategory();
		createdCategoryIds.add(id);
		int finalSize = getCategorySize();
		Assert.assertEquals(initialSize + 1, finalSize);
		
	}

	@SuppressWarnings("unchecked")
	private int getCategorySize() {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = null;
		Transaction tx = null;
		int finalSize = 0;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Category> categories = session.createCriteria(Category.class).list();
			finalSize = categories.size();
			tx.commit();
		} finally {
			session.close();
		}
		return finalSize;
	}

	private long createNewCategory() {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Category category = new Category();
			category.setName("Test Category");
			category.setDescription("Example for test");
			Long id = (Long) session.save(category);
			tx.commit();
			return id;
		} finally {
			session.close();
		}
	}
	
	private long deleteCategory(long id) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Category category = (Category) session.load(Category.class, id);
			session.delete(category);
			tx.commit();
			return id;
		} finally {
			session.close();
		}
	}

	private SessionFactory getSessionFactory() {
		return context.getBean(SessionFactory.class);
	}
}
