package com.store.database.impl.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.store.models.impl.Customer;
import com.store.models.impl.Product;



public class HibernateUtil {

	private static HibernateUtil instance;
	private SessionFactory sessionFactory;

	public static HibernateUtil getInstance() throws HibernateException {
		if (instance == null) {
			instance = new HibernateUtil();
			instance.initDB();
		}
		return instance;
	}

	private void initDB() throws HibernateException {

		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		//
		registerEntities(configuration);
		//
		sessionFactory = configuration.buildSessionFactory(builder.build());

	}

	public Session openSession() throws HibernateException {
		Session currentSession = sessionFactory.openSession();
		return currentSession;
	}

	public Transaction openTransaction(Session session) {
		return session.beginTransaction();
	}

	public void commit(Transaction transaction) {
		transaction.commit();
	}

	public void destroy() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}

	public Session startUnitOfWork() throws HibernateException {

		Session currentSession = sessionFactory.openSession();

		currentSession.beginTransaction();

		return currentSession;
	}

	public void endUnitOfWork(Session session) throws HibernateException {
		try {
			session.getTransaction().commit();
			session.flush();

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			session.clear();

		} finally {
			session.close();
		}
	}

	private void registerEntities(Configuration configuration) {
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Product.class);
		
	}
}
