package aks.geo.trends.ws.spring.daos;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aks.geo.trends.ws.hibernate.Keyword;
import aks.geo.trends.ws.hibernate.Region;

@Repository
public class KeywordsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void saveKeywordList(List<Keyword> keywords) {

		Session session = sessionFactory.getCurrentSession();
		
		for (Keyword keyword : keywords) {
			session.save(keyword);
		}
	}

	public Map<String, Date> removeKeywordsForRegion(Region reg) {
		
		Map<String, Date> addedDateMap = new HashMap<>();
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Keyword.class);
		
		criteria.add(Restrictions.eqOrIsNull("region", reg));
		List<Keyword> list = (List<Keyword>)criteria.list();
		
		for (Keyword keyword : list) {
			
			addedDateMap.put(keyword.getKeyword(), keyword.getAddedDate());
			session.delete(keyword);
		}
		session.flush();
		
		return addedDateMap;
	}

	public List<Keyword> getKeywords(Region region) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Keyword.class);
		criteria.add(Restrictions.eq("region", region));
		
		List<Keyword> list = (List<Keyword>) criteria.list();
		
		return list;
	}
}
