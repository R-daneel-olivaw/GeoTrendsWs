package aks.geo.trends.ws.json;

import java.util.List;

public class JsonRegionalTrending {
	
	private JsonRegion region;
	
	private List<JsonKeyword> trending;

	public JsonRegion getRegion() {
		return region;
	}

	public void setRegion(JsonRegion region) {
		this.region = region;
	}

	public List<JsonKeyword> getTrending() {
		return trending;
	}

	public void setTrending(List<JsonKeyword> trending) {
		this.trending = trending;
	}
	
	

}
