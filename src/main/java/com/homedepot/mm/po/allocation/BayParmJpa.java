/**
 * 
 */
package com.homedepot.mm.po.allocation;

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
@Table(name = "TLALLOC_BAYPARM_STG")
public class BayParmJpa {

	@Id
	private Long sequencenumber;
	private int uploadid;

	private String locationid;

	private String productcode;

	private double bay_parm_val;

	private String activeflag;

}
