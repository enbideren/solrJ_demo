package net.datafans.exercise.solr.product;

public class Product {
	private int id;
	private String title;
	private String cat;

	public Product(int id, String title, String cat) {
		this.id = id;
		this.title = title;
		this.setCat(cat);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}


}
