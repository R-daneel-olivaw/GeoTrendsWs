package aks.geo.trends.ws.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aks.geo.trends.ws.hibernate.Region;
import aks.geo.trends.ws.spring.daos.RegionsDao;

@Service
public class RegionService {

	@Autowired
	private RegionsDao regionDao;

	@Transactional
	public Region getRegion(String identifier) {
		Region region = regionDao.getRegion(identifier);

		return region;
	}

}
