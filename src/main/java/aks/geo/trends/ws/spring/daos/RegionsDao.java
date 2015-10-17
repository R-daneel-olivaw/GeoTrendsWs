package aks.geo.trends.ws.spring.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aks.geo.trends.ws.hibernate.Region;

@Repository
public class RegionsDao {
	
	@Autowired
	SessionFactory sessionFactory;


	public Region getRegion(String region) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Region.class);
		
		criteria.add(Restrictions.eq("region", region));
		List<Region> list = (List<Region>)criteria.list();
		
		if(list.size()!=0)
		{
			return list.get(0);
		}
		
		return null;
	}


	public void saveRegion(Region reg) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(reg);
		
	}
}
