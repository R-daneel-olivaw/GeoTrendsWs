package aks.geo.trends.ws.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aks.geo.trends.ws.hibernate.Region;
import aks.geo.trends.ws.json.JsonRegionalTrending;
import aks.geo.trends.ws.spring.services.KeywordService;
import aks.geo.trends.ws.spring.services.RegionService;

@Controller
public class WelcomeController {

	@Autowired
	private KeywordService keywordService;

	@Autowired
	private RegionService regionService;

	@RequestMapping(value = "/test")
	public String landingPage(Model model) {
		return "test";
	}

	@RequestMapping(value = "/trending/{regionId}")
	public String listIndia(Model model,@PathVariable String regionId) {
		Region region = regionService.getRegion(regionId);

		List<String> keywords = keywordService.getTrending(region);
		model.addAttribute("keywords", keywords);
		model.addAttribute("reg", region.getRegion());

		return "testList";
	}

	@RequestMapping(value = "/trending/{regionId}", consumes = "application/json")
	public @ResponseBody JsonRegionalTrending listIndiaJson(@PathVariable String regionId) {
		Region region = regionService.getRegion(regionId);

		JsonRegionalTrending regionalTrending = keywordService.getTrendingJson(region);

		return regionalTrending;
	}

}
