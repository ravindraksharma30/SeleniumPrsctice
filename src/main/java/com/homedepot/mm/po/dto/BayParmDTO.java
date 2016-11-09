package com.homedepot.mm.po.dto;

import lombok.Data;

@Data
public class BayParmDTO {
	public int UPLOADID;
	public int SEQUENCENUMBER;
	public int LOCATIONID;
	public String PRODUCTCODE;
	public double BAY_PARM_VAL;
	public String ACTIVEFLAG;
}
