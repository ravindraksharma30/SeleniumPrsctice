package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TLD_ALLOC_ONBRD_PARM")
public class AllocationOnBoard {
	private Integer tld_alloc_onbrd_parm_id;
	private Integer tld_alloc_parm_typ_cd;
	private Integer parm_mvndr_prty_id;
	private Integer parm_item_id;
	private Integer parm_loc_id;
	private String parm_loc_type_cd;
	private String parm_flg_val;
	private Integer parm_intg_val;
	private LocalDate parm_dt_val;
	private String parm_char_val;
	private BigDecimal parm_dec_val;
	private String actv_flg;
}
