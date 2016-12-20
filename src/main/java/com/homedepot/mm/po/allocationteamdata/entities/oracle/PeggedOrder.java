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

	// private String src_loc_nbr; // May be Needed
	// private String src_loc_typ_cd; // DC - May be Needed
	// private BigDecimal mvndr_nbr; // What's this?
	// private BigDecimal mer_dept_nbr;// What's this?
	// // Quantity in AL_DETAIL?
	// private BigDecimal prnt_peg_ord_id;// May be Needed - What's this?
	// private BigDecimal peg_ord_wrk_id;// May be Needed - What's this?
	// private BigDecimal soq_ref_id;// May be Needed - What's this?
	// private BigDecimal peg_ord_stat_cd;// May be Needed - What's this?
	// private String prcsd_flg;// Not Needed
	// private BigDecimal buy_uom_qty; // is this Packsize or something else? -
	// // AL_DETAIL
	//
	// private BigDecimal peg_ord_rsn_typ_cd;// May be Needed - What's this?
	// private BigDecimal sku_sub_typ_cd;// May be Needed - What's this?
	// private Timestamp port_expctd_arvl_ts;// May be Needed - What's this?

}
