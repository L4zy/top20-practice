package top20.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top20.entity.Artist;
import top20.entity.TopArtistDto;
import top20.entity.TopSongDto;
import top20.util.DateUtil;

@Service("topService")
public class TopService {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked" })
	public List<TopArtistDto> artistOfTheWeek() {

		Session session = sessionFactory.getCurrentSession();

		Date today = Calendar.getInstance().getTime();
		
		Date startDate = DateUtil.getFirstDayOfPreviouseWeek(today);
		Date endDate = DateUtil.getLastDayOfPreviouseWeek(today);

		Criteria cr = session.createCriteria(Artist.class, "artist");

		cr.createAlias("artist.songs", "song");
		cr.createAlias("song.vots", "vote");
		cr.setProjection(Projections
				.projectionList()
				.add(Projections.property("stageName"), "artist")
				.add(Projections.alias(Projections.count("artist.id"),
						"votCount"))
				.add(Projections.alias(Projections.groupProperty("artist.id"),
						"artistId")));
		cr.add(Restrictions.ge("vote.votDate", startDate));
		cr.add(Restrictions.le("vote.votDate", endDate));
		cr.addOrder(Order.desc("votCount"))
				.setMaxResults(5)
				.setResultTransformer(
						Transformers.aliasToBean(TopArtistDto.class));

		return cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<TopSongDto> songOfTheWeek() {

		Session session = sessionFactory.getCurrentSession();

		Date today = Calendar.getInstance().getTime();
		
		Date startDate = DateUtil.getFirstDayOfPreviouseWeek(today);
		Date endDate = DateUtil.getLastDayOfPreviouseWeek(today);
		Query q = session
				.createQuery(
						"select s.name as song , count (v.song) as votCount FROM Song As s INNER JOIN s.vots v WHERE v.votDate BETWEEN :stDate AND :edDate GROUP BY v.song ORDER BY votCount DESC")
				.setMaxResults(5)
				.setResultTransformer(
						Transformers.aliasToBean(TopArtistDto.class));
		q.setParameter("stDate", startDate).setParameter("edDate", endDate);

		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<TopArtistDto> mostPopulatArtist() {

		Session session = sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(Artist.class, "artist");

		cr.createAlias("artist.songs", "song");
		cr.createAlias("song.vots", "vote");
		cr.setProjection(Projections
				.projectionList()
				.add(Projections.property("stageName"), "artist")
				.add(Projections.alias(Projections.count("artist.id"),
						"votCount"))
				.add(Projections.alias(Projections.groupProperty("artist.id"),
						"artistId")));
		cr.addOrder(Order.desc("votCount"))
				.setMaxResults(5)
				.setResultTransformer(
						Transformers.aliasToBean(TopArtistDto.class));

		return cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<TopSongDto> mostPopulatSong() {

		Session session = sessionFactory.getCurrentSession();

		Query q = session
				.createQuery(
						"select s.name as song , count (v.song) as votCount FROM Song As s INNER JOIN s.vots v GROUP BY v.song ORDER BY votCount DESC")
				.setMaxResults(5)
				.setResultTransformer(
						Transformers.aliasToBean(TopSongDto.class));
		return q.list();
	}

}