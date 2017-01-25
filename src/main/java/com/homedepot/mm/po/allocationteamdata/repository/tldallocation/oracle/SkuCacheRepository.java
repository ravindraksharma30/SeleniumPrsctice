package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;

/**
 * SKUCacheRepository is used to do CRUD operations for the table STG_TLD_ALLOC.
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * 
 * @author gxk8870
 *
 */
@Repository("SkuCacheRepository")
@Transactional("transactionManager")
public interface SkuCacheRepository extends JpaRepository<SkuCache, Integer> {

	/**
	 * 
	 * @param transloadDcNumber
	 * @param skuNumber
	 * @return
	 */
	public SkuCache findByTransloadDcNumberAndSkuNumber(final String transloadDcNumber, final Integer skuNumber);
}
