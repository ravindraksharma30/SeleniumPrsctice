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
	@Query(value = "select a from PeggedOrder a where a.bol_nbr is null and a.inb_ord_nbr = ?1")
	public List<PeggedOrder> findPeggedOrders(String poNumber);

}