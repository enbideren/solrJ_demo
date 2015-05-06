package net.datafans.exercise.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

class Product {
	private int id;
	private String title;
	private String type;
	private String subtype;

	/**
	 * description:
	 */
	public Product(int id, String title, String type, String subtype) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.subtype = subtype;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getSubtype() {
		return subtype;
	}

}

public class Index {
	private static List<Product> products = new ArrayList<Product>();
	static {
		products.add(new Product(1, "5d2", "dc", "canon"));
		products.add(new Product(2, "5d3", "dc", "canon"));
		products.add(new Product(3, "d7000", "dc", "nikon"));
		products.add(new Product(4, "d8000", "dc", "nikon"));
		products.add(new Product(5, "ip5", "phone", "iphone"));
		products.add(new Product(6, "s3", "phone", "sumsung"));

	}

	public static void main(String[] args) throws SolrServerException, IOException {
		HttpSolrServer server = SolrServer.getServer();

		for (Product p : products) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", p.getId());
			doc.addField("title", p.getTitle());
			doc.addField("type", p.getType());
			doc.addField("url", p.getSubtype());
			server.add(doc);
		}

		server.commit();
	}

}
