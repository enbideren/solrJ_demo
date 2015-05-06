package net.datafans.exercise.solr.spring;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class Product {
	@Field("id")
	private String id;
	@Field("title")
	private String title;
	@Field("type")
	private List<String> type;
	@Field("subtype")
	private String subtype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getSubtype() {
		return subtype;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", type=" + type + ", subtype=" + subtype + "]";
	}

}
