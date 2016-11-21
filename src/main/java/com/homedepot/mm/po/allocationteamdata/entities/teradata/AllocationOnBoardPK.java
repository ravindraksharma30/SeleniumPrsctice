/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Data
@Embeddable
public class AllocationOnBoardPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6344991612651370957L;
	private Integer tld_alloc_onbrd_parm_id;

	private Integer tld_alloc_parm_typ_cd;

}
