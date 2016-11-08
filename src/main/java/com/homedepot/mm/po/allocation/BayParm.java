/**
 * 
 */
package com.homedepot.mm.po.allocation;

import java.io.Serializable;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Data
public class BayParm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011906850315814534L;
	private int TLD_ALLOC_ONBRD_PARM_ID;
	private int TLD_ALLOC_PARM_TYP_CD;
	private int PARM_ITEM_ID;
	private int PARM_LOC_ID;
	private String PARM_LOC_TYP_CD;
	private int PARM_INTG_VAL;
	private String ACTV_FLG;
}
