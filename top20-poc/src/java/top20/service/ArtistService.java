package top20.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Artist;

@Service("artistService")
public class ArtistService {

	@Autowired
	SessionFactory sessionFactory;

	public void saveArtist(Artist artist) {

		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		tx.begin();
		try {
			session.save(artist);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
