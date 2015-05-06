package net.datafans.exercise.solr.spring;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-solr.xml" })
public class ProductDaoTest {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ProductDao productDao;

	@Before
	public void setUp() throws Exception {
		log.warn("Begin Test");
	}

	@Test
	public void test() {
//		productDao.getAll();
	}

	@After
	public void tearDown() throws Exception {
		log.warn("End Test");
	}
}
