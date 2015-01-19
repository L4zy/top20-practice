package top20.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Artist;
import top20.entity.Song;
import top20.util.DateUtil;

@Service("topService")
public class TopService {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	public Artist artistOfTheWeek() {

		Session session = sessionFactory.getCurrentSession();

		Date startDate = DateUtil.getFirstDayOfLastWeek();
		Date endDate = DateUtil.getLastDayOfLastWeek();

		Criteria cr = session.createCriteria(Artist.class, "artist");

		cr.createAlias("artist.songs", "song");
		cr.createAlias("song.vots", "vote");
		cr.setProjection(Projections
				.projectionList()
				.add(Projections.property("realName"), "Real Name")
				.add(Projections.property("stageName"), "Stage Name")
				.add(Projections.alias(Projections.count("artist.id"), "rCount"))
				.add(Projections.alias(Projections.groupProperty("artist.id"),
						"Artist Id")));
		cr.add(Restrictions.ge("vote.votDate", startDate));
		cr.add(Restrictions.le("vote.votDate", endDate));
		cr.addOrder(Order.desc("rCount")).setMaxResults(1);

		List result = cr.list();
		Artist artist = new Artist();
		if (result.size() == 1) {
			Object[] o = (Object[]) result.get(0);
			artist.setRealName((String) o[0]);
			artist.setStageName((String) o[1]);
		}

		return artist;
	}

	@SuppressWarnings("rawtypes")
	public Song songOfTheWeek() {

		Session session = sessionFactory.getCurrentSession();

		Date startDate = DateUtil.getFirstDayOfLastWeek();
		Date endDate = DateUtil.getLastDayOfLastWeek();
		Query q = session
				.createQuery(
						"select s.name , count (v.song) as rCount FROM Song As s INNER JOIN s.vots v WHERE v.votDate BETWEEN :stDate AND :edDate GROUP BY v.song ORDER BY rCount DESC")
				.setMaxResults(1);
		q.setParameter("stDate", startDate).setParameter("edDate", endDate);
		
		List restultList = q.list();
		if (restultList.size() == 0) {
			return null;
		}
		Song s = new Song();
		Object restult = restultList.get(0);
		if (restult instanceof Object[]) {
			Object[] o2 = (Object[]) restult;
			System.out.println((String) o2[0]);
			s.setName((String) o2[0]);
		}
		return s;
	}

	@SuppressWarnings("rawtypes")
	public Artist mostPopulatArtist() {

		Session session = sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(Artist.class, "artist");

		cr.createAlias("artist.songs", "song");
		cr.createAlias("song.vots", "vote");
		cr.setProjection(Projections
				.projectionList()
				.add(Projections.property("realName"), "Real Name")
				.add(Projections.property("stageName"), "Stage Name")
				.add(Projections.alias(Projections.count("artist.id"), "rCount"))
				.add(Projections.alias(Projections.groupProperty("artist.id"),
						"Artist Id")));
		cr.addOrder(Order.desc("rCount")).setMaxResults(1);

		List result = cr.list();
		Artist artist = new Artist();
		if (result.size() == 1) {
			Object[] o = (Object[]) result.get(0);
			artist.setRealName((String) o[0]);
			artist.setStageName((String) o[1]);
		}

		return artist;
	}

	public Song mostPopulatSong() {

		Session session = sessionFactory.getCurrentSession();

		Query q = session
				.createQuery(
						"select s.name , count (v.song) as rCount FROM Song As s INNER JOIN s.vots v GROUP BY v.song ORDER BY rCount DESC")
				.setMaxResults(1);
		Object restult = q.list().get(0);
		Song s = new Song();

		if (restult instanceof Object[]) {
			Object[] o2 = (Object[]) restult;
			s.setName((String) o2[0]);
		}
		return s;
	}

}