package top20.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Vote;


@Service("voteService")
public class VoteService {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public void saveVote(Vote vot){
		Session session = sessionFactory.getCurrentSession();
		session.save(vot);
	}
}
