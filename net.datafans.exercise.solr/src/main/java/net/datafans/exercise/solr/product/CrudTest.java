package net.datafans.exercise.solr.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class CrudTest {
	private static List<Product> products = new ArrayList<Product>();
	private static HttpSolrServer server = SolrServer.getServer();
	static {
		products.add(new Product(1, "5d2", "dc"));
		products.add(new Product(2, "5d3", "dc"));
		products.add(new Product(3, "d7000", "dc"));
		products.add(new Product(4, "d8000", "dc"));
		products.add(new Product(5, "ip5", "phone"));
		products.add(new Product(6, "s3", "phone"));
	}

	public static void index() throws SolrServerException, IOException {
		long start = System.currentTimeMillis();
		for (Product p : products) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", p.getId());
			doc.addField("title", p.getTitle());
			doc.addField("cat", p.getCat());
			server.add(doc);
		}
		server.commit();
		System.out.println("Index: " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void update() throws SolrServerException, IOException {
		System.out.println("-------------------更新------------------");
		long start = System.currentTimeMillis();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", 1);
		doc.addField("title", "5d2-new");
		doc.addField("cat", "dc");
		server.add(doc);
		server.commit();
		System.out.println("Update: " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void delete(String id) throws SolrServerException, IOException {
		System.out.println("-------------------删除------------------");
		long start = System.currentTimeMillis();
		server.deleteById(id);
		server.commit();
		System.out.println("Delete: " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void search() throws SolrServerException {
		System.out.println("-------------------查询------------------");
		long start = System.currentTimeMillis();
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.addField("title");
		query.addField("id");
		query.addField("cat");
		query.setStart(0);
		query.setRows(100);
		query.addSort("id", ORDER.asc);

		System.out.println(query);

		QueryResponse response = server.query(query);

		SolrDocumentList docs = response.getResults();
		Iterator<?> it = docs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Search: " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void main(String[] args) throws SolrServerException, IOException, InterruptedException {
		index();
		search();
		update();
		search();
		delete("1");
		search();
	}

}
