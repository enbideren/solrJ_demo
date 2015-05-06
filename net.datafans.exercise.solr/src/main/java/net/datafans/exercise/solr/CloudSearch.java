package net.datafans.exercise.solr;

import java.net.MalformedURLException;
import java.util.Iterator;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class CloudSearch {

	public static void main(String[] args) throws SolrServerException, MalformedURLException {
		CloudSolrServer server = SolrServer.getCloudServer();

		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.setStart(0);
		query.setRows(100);

		QueryResponse response = server.query(query);
		SolrDocumentList docs = response.getResults();
		Iterator<?> it = docs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
