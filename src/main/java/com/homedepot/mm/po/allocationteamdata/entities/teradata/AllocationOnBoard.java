package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TLD_ALLOC_ONBRD_PARM")
/**
 * 
 * @author gxk8870
 *
 */
public class AllocationOnBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862638507947558225L;
	@EmbeddedId
	private AllocationOnBoardPK id;
	private Integer parm_mvndr_prty_id;
	private Integer parm_item_id;
	private Integer parm_loc_id;
	private String parm_loc_typ_cd;
	private String parm_flg_val;
	private Integer parm_intg_val;
	private LocalDate parm_dt_val;
	private String parm_char_val;
	private BigDecimal parm_dec_val;
	private String actv_flg;
}
