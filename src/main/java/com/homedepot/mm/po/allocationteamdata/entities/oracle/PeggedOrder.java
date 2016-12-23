/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.oracle;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Data
@Entity
@Table(name = "VIRT_PEG_ORD")
public class PeggedOrder {

	@Id
	private BigDecimal virt_peg_ord_id;
	private BigDecimal sku_nbr;
	private String inb_ord_nbr;
	private String bol_nbr;
	private BigDecimal peg_ord_qty;
	private String dest_loc_nbr;
	private String dest_loc_typ_cd;
	private BigDecimal peg_typ_cd;

}
