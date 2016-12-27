package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
/**
 * 
 * @author gxk8870
 *
 */
public class AllocationOnBoardResource extends ResourceSupport {
	private Integer onboardParmId;
	private Integer parmTypeCode;
	private Integer parm_mvndr_prty_id;
	private Integer parm_item_id;
	private Integer parmLocationId;
	private String parmLocationTypeCode;
	private String parmFlagValue;
	private Integer parmIntegerValue;
	private LocalDate parmDateValue;
	private String parmCharValue;
	private BigDecimal parmDecimalValue;
	private String activeFlag;

	/**
	 *
	 */
	public AllocationOnBoardResource(){

	}

	/**
	 *
	 * @param tld_alloc_onbrd_parm_id
	 * @param tld_alloc_parm_typ_cd
	 * @param parm_mvndr_prty_id
	 * @param parm_item_id
	 * @param parm_loc_id
	 * @param parm_loc_type_cd
	 * @param parm_flg_val
	 * @param parm_intg_val
	 * @param parm_dt_val
	 * @param parm_char_val
	 * @param parm_dec_val
	 * @param actv_flg
	 */
	public AllocationOnBoardResource(Integer tld_alloc_onbrd_parm_id, Integer tld_alloc_parm_typ_cd,
			Integer parm_mvndr_prty_id, Integer parm_item_id, Integer parm_loc_id, String parm_loc_type_cd,
			String parm_flg_val, Integer parm_intg_val, LocalDate parm_dt_val, String parm_char_val,
			BigDecimal parm_dec_val, String actv_flg) {

		this.onboardParmId = tld_alloc_onbrd_parm_id;
		this.parmTypeCode = tld_alloc_parm_typ_cd;
		this.parm_mvndr_prty_id = parm_mvndr_prty_id;
		this.parm_item_id = parm_item_id;
		this.parmLocationId = parm_loc_id;
		this.parmLocationTypeCode = parm_loc_type_cd;
		this.parmFlagValue = parm_flg_val;
		this.parmIntegerValue = parm_intg_val;
		this.parmDateValue = parm_dt_val;
		this.parmCharValue = parm_char_val;
		this.parmDecimalValue = parm_dec_val;
		this.activeFlag = actv_flg;
	}
}
