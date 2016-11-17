package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AllocationOnBoardResource extends ResourceSupport {
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
	
	public AllocationOnBoardResource(Integer tld_alloc_onbrd_parm_id, Integer tld_alloc_parm_typ_cd, Integer parm_mvndr_prty_id, 
			Integer parm_item_id, Integer parm_loc_id, String parm_loc_type_cd, String parm_flg_val, Integer parm_intg_val,
			LocalDate parm_dt_val, String parm_char_val, BigDecimal parm_dec_val, String actv_flg) {
		
		this.tld_alloc_onbrd_parm_id = tld_alloc_onbrd_parm_id;
		this.tld_alloc_parm_typ_cd = tld_alloc_parm_typ_cd;
		this.parm_mvndr_prty_id = parm_mvndr_prty_id;
		this.parm_item_id = parm_item_id;
		this.parm_loc_id = parm_loc_id;
		this.parm_loc_type_cd = parm_loc_type_cd;
		this.parm_flg_val = parm_flg_val;
		this.parm_intg_val = parm_intg_val;
		this.parm_dt_val = parm_dt_val;
		this.parm_char_val = parm_char_val;
		this.parm_dec_val = parm_dec_val;
		this.actv_flg = actv_flg;
	}
}
