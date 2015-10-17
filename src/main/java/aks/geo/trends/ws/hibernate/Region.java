package aks.geo.trends.ws.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions", catalog = "geotrends")
public class Region {
	
	private Integer id;
	private String region;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "region", nullable = false, length = 10)
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	
}
