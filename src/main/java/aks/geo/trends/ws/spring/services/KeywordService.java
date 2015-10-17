package aks.geo.trends.ws.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aks.geo.trends.ws.hibernate.Keyword;
import aks.geo.trends.ws.hibernate.Region;
import aks.geo.trends.ws.spring.daos.KeywordsDao;
import aks.geo.trends.ws.spring.daos.RegionsDao;

@Service
public class KeywordService {

	@Autowired
	KeywordsDao keywordDao;

	@Autowired
	RegionsDao regionsDao;

	@Transactional
	public void updateDatabase(List<String> trending, String region) {

		Region reg = regionsDao.getRegion(region);
		if (reg == null) {
			reg = new Region();
			reg.setRegion(region);

			regionsDao.saveRegion(reg);
		}

		Map<String, Date> addedDateMap = keywordDao.removeKeywordsForRegion(reg);

		List<Keyword> keywords = convertToDbPojos(trending, reg, addedDateMap);
		keywordDao.saveKeywordList(keywords);
	}

	private List<Keyword> convertToDbPojos(List<String> trending, Region reg, Map<String, Date> addedDateMap) {
		// TODO Auto-generated method stub

		List<Keyword> keywords = new ArrayList<>();
		for (String item : trending) {

			Keyword k = new Keyword();
			k.setKeyword(item);
			k.setRegion(reg);

			Date date = addedDateMap.get(item);
			if (date != null) {
				k.setAddedDate(date);
			} else {
				k.setAddedDate(new Date());
			}

			keywords.add(k);
		}

		return keywords;
	}

	@Transactional
	public List<String> getTrending(Region region) {
		// TODO Auto-generated method stub
		 
		List<String> stringKeywords = new ArrayList<>();
		
		List<Keyword> keywords = keywordDao.getKeywords(region);
		for (Keyword keyword : keywords) {
			
			stringKeywords.add(keyword.getKeyword());			
		}
		
		return stringKeywords;
	}
}
