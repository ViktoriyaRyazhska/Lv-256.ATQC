package com.regres.application;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

	private static String CONFIG_FILE_LOCATION = "resources/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static final Configuration cfg = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;

	public static Session currentSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		if (session == null) {
			if (sessionFactory == null) {
				try {
					cfg.configure();
					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build();
					sessionFactory = cfg.buildSessionFactory(serviceRegistry);
				} catch (Exception e) {
					System.err.println("Error Creating SessionFactory");
					e.printStackTrace();
				}
			}
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}

	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}

	private HibernateSessionFactory() {
	}

}
