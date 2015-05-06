package net.datafans.exercise.solr;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class Search {

	public static void main(String[] args) throws SolrServerException {
		HttpSolrServer server = SolrServer.getServer();

		SolrQuery query = new SolrQuery();
		query.setQuery("type:dc");
		query.addField("title");
		query.addField("id");
		query.addField("type");
		query.addField("url");
		query.setStart(0);
		query.setRows(100);
		query.addSort("id", ORDER.asc);

		query.setHighlight(true);
		query.addHighlightField("type");
		query.setHighlightSimplePre("<B>");
		query.setHighlightSimplePost("</B>");
		query.setHighlightSnippets(2);
		query.setHighlightFragsize(1000);

		query.setFacet(true).setFacetMinCount(1).setFacetLimit(5).addFacetField("url");
		query.addFacetQuery("url:canon");
		query.addFilterQuery("url:canon");

		System.out.println(query);

		QueryResponse response = server.query(query);

		List<FacetField> facetFields = response.getFacetFields();
		System.out.println(facetFields);

		SolrDocumentList docs = response.getResults();
		Iterator<?> it = docs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Map<String, Integer> docs88 = response.getFacetQuery();
		System.out.println(docs88);

	}

}
