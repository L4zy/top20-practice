package top20.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Song;

@Service("songService")
public class SongService {

	@Autowired
	SessionFactory sessionFactory;

	public void saveSong(Song song) {

		Session session = sessionFactory.getCurrentSession();
		session.save(song);
	}

	@SuppressWarnings("unchecked")
	public List<Song> list() {

		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Song.class).list();

	}

}
