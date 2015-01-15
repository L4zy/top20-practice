package top20.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Artist;

@Service("artistService")
public class ArtistService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addArtist(Artist artist){
		
		Session session= sessionFactory.getCurrentSession();
		try{
			session.save(artist);
		}catch(Exception e){
			System.err.println(e);
		}
	}

}
