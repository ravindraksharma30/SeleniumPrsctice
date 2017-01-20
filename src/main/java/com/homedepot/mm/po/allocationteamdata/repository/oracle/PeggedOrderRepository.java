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
 * PeggedOrderRepository is used to do CRUD operations for the table
 * VIRT_PEG_ORD.
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * 
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

	@Query(value = "select a from PeggedOrder a where a.bol_nbr = ?1 and a.inb_ord_nbr = ?2 and a.sku_nbr = ?3 and a.src_loc_typ_cd = 'DC' and a.dest_loc_typ_cd = 'DC' order by a.dest_loc_nbr")
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber);

}
