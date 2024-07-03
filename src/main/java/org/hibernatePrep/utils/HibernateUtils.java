package org.hibernatePrep.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatePrep.models.Song;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				// configuration.configure();
				configuration.addAnnotatedClass(Song.class);
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactory;
	}

}
