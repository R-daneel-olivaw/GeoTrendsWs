package aks.geo.trends.ws.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aks.geo.trends.ws.hibernate.Keyword;
import aks.geo.trends.ws.hibernate.Region;
import aks.geo.trends.ws.spring.services.KeywordService;
import aks.geo.trends.ws.spring.services.RegionService;

@Controller
public class WelcomeController {
	
	@Autowired
	private KeywordService keywordService;
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="/test")
	public String landingPage(Model model)
	{
		return "test";
	}
	
	@RequestMapping(value="/india")
	public String listIndia(Model model)
	{
		Region region = regionService.getRegion("IN");
		
		List<String> keywords = keywordService.getTrending(region);
		model.addAttribute("keywords", keywords);
		model.addAttribute("reg", "India");
		
		return "testList";
	}

}
