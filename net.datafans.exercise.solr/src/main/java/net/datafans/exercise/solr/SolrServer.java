package net.datafans.exercise.solr;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class SolrServer {

	public static HttpSolrServer getServer() {
		String url = "http://127.0.0.1:8983/solr/collection1";
		HttpSolrServer server = new HttpSolrServer(url);
		server.setSoTimeout(3000); // socket read timeout
		server.setConnectionTimeout(1000);
		server.setDefaultMaxConnectionsPerHost(1000);
		server.setMaxTotalConnections(10);
		server.setFollowRedirects(false); // defaults to false
		server.setAllowCompression(true);
		server.setMaxRetries(1);
		return server;
	}

	public static CloudSolrServer getCloudServer() throws MalformedURLException {
		CloudSolrServer cloudSolrServer = new CloudSolrServer("127.0.0.1:9983");
		cloudSolrServer.setDefaultCollection("collection1");
		cloudSolrServer.setZkClientTimeout(30000);
		cloudSolrServer.setZkConnectTimeout(10000);
		return cloudSolrServer;
	}
}