package aks.geo.trends.ws.json;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import aks.geo.trends.ws.json.util.CustomDateSerializer;

public class JsonKeyword {

	private String keyword;
	private Date addedDate;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

}
