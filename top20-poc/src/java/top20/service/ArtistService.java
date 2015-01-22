package top20.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Artist;

@Service("artistService")
public class ArtistService {

	@Autowired
	SessionFactory sessionFactory;

	public void saveArtist(Artist artist) {

		Session session = sessionFactory.getCurrentSession();
		session.save(artist);
	}

	@SuppressWarnings("unchecked")
	public List<Artist> list() {

		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Artist.class).list();

	}
	
	
	public void update(Artist artist) {

		Session session = sessionFactory.getCurrentSession();
		session.update(artist);
		session.flush();
	}

	
	public void delete(Artist artist) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(artist);
		session.flush();
	}

}
