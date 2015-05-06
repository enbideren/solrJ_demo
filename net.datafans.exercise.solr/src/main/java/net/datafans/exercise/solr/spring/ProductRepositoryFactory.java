//package net.datafans.exercise.solr.spring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.solr.core.SolrOperations;
//import org.springframework.data.solr.repository.support.SolrRepositoryFactory;
//
//public class ProductRepositoryFactory {
//	@Autowired
//    private SolrOperations solrTemplate;
//
//	public ProductRepository create() {
//        return new SolrRepositoryFactory(this.solrTemplate).getRepository(ProductRepository.class);
//    }
//}