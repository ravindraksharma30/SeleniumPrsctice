package com.homedepot.mm.po.allocationteamdata.tldallocation.oracle.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.configuration.H2Configuration;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.SkuCacheRepository;

/**
 * Tests the SkuCacheRepositoy to ensure a proper connection. Utilizes H2 for
 * testing.
 * 
 * @author gxk8870
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/SkuCachePreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/SkuCachePostTest.sql") })
public class SkuCacheRepositiryTest {

	@Autowired
	private SkuCacheRepository skuCacheRepository;

	/**
	 * Tests for a repository connection.
	 */
	@Test
	public void testSkuCacheRepository() {
		SkuCache skuCache = skuCacheRepository.findByTransloadDcNumberAndSkuNumber("5097", 1000358177);
		assertNotNull(skuCache);
		assertEquals("5097", skuCache.getTransloadDcNumber());
		assertEquals((Integer) 1000358177, skuCache.getSkuNumber());
		assertEquals("123456", skuCache.getCreateProgramId());
	}
}
