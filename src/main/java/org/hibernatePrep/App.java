package org.hibernatePrep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatePrep.models.Song;
import org.hibernatePrep.utils.HibernateUtils;

public class App {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		//Session session=sessionFactory.openSession();
		
		//CREATE
		
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Song song = new Song(); // song.setId(3); song.setSongName("Jai Ho");
			song.setSinger("AR Rehman");

			session.beginTransaction();
			session.save(song);
			session.getTransaction().commit();
			session.close();
		}
		 
		 
		
		//READ
		/*
		 * Session session2 = sessionFactory.openSession(); Song song2 =
		 * session2.get(Song.class, 1);
		 * 
		 * System.out.println(song2);
		 */
		 
		
		//UPDATE
		
		
		/*
		 * if (sessionFactory != null) { Session session2 =
		 * sessionFactory.openSession(); Song song2 = session2.get(Song.class, 3);
		 * System.out.println(song2); session2.beginTransaction();
		 * song2.setSongName("Heeriyeee Heeriyeee"); song2.setSinger("Justin Bieber");
		 * session2.beginTransaction(); session2.update(song2);
		 * session2.getTransaction().commit(); session2.close();
		 * 
		 * }
		 */
		 
		 
		// MERGE
		
		if (sessionFactory != null) {
			Session session2 = sessionFactory.openSession();
			Song song2 = session2.get(Song.class, 3);
			System.out.println(song2); // session2.beginTransaction();
			// song2.setSongName("Heeriyeee Heeriyeee"); //
			song2.setSinger("Justin Bieber");
			session2.beginTransaction();
			// session2.update(song2); //session2.getTransaction().commit();
			session2.close();
			song2.setSongName("Baby Baby");
			Session session3 = sessionFactory.openSession();
			Song song3 = session3.get(Song.class, 3);
			session3.beginTransaction();
			session3.update(song2); // session3.merge(song2);
			session3.getTransaction().commit();
			session3.close();
		}
		 
		
		//DELETE
		/*
		 * if(sessionFactory!=null) { Session session2 = sessionFactory.openSession();
		 * Song song2 = session2.get(Song.class, 1); session2.beginTransaction();
		 * session2.delete(song2); session2.getTransaction().commit(); }
		 */
	}

	

}
