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

import pl.waw.spending.core.SpendingApplication;
import pl.waw.spending.domain.Category;

public class HibernateConfigurationTest {
	
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
		return SpendingApplication.INSTANCE.getContext().getBean(SessionFactory.class);
	}
}
