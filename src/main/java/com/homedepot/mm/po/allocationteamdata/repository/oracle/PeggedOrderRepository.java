/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.repository.oracle;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;

/**
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * @author axd8472
 *
 */
@Repository("PeggedOrderRepository")
public interface PeggedOrderRepository extends JpaRepository<PeggedOrder, BigDecimal> {

	/**
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @return
	 */
	// @Query(value = "select a from PeggedOrder a where a.bol_nbr is null and
	// a.inb_ord_nbr = ?1")
	// public List<PeggedOrder> findPeggedOrders(String poNumber);

	@Query(value = "select a from PeggedOrder a where a.inb_ord_nbr = ?1 and a.sku_nbr = ?2 ")
	public List<PeggedOrder> findPeggedOrders(String poNumber, BigDecimal skuNumber);

	@Query(value = "select a from PeggedOrder a where a.bol_nbr = ?1 and a.inb_ord_nbr = ?2 and a.sku_nbr = ?3 ")
	public List<PeggedOrder> findPeggedOrders(String asnNumber, String poNumber, BigDecimal skuNumber);

}
