/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.oracle;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
	private String bol_nbr;
	private String src_loc_nbr;
	private String dest_loc_nbr;
	private String src_loc_typ_cd;
	private String dest_loc_typ_cd;
	private BigDecimal mvndr_nbr;
	private BigDecimal mer_dept_nbr;
	private BigDecimal sku_nbr;
	private BigDecimal peg_ord_qty;
	private String inb_ord_nbr;
	private BigDecimal prnt_peg_ord_id;
	private BigDecimal peg_ord_wrk_id;
	private BigDecimal soq_ref_id;
	private BigDecimal peg_ord_stat_cd;
	private String prcsd_flg;
	private BigDecimal buy_uom_qty;
	private BigDecimal peg_typ_cd;
	private BigDecimal peg_ord_rsn_typ_cd;
	private BigDecimal sku_sub_typ_cd;
	private Timestamp port_expctd_arvl_ts;

}
