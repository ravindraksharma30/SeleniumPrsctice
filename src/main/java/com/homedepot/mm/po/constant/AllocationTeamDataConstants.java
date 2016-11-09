package com.homedepot.mm.po.constant;

public class AllocationTeamDataConstants {
	
	public static final String READ_TLD_ALLOC_ONBRD_PARM = "SELECT * FROM QA_TLALLOCCSTM_EXE.TLALLOC_BAYPARM_STG"
			+ " WHERE LOCATIONID = %s"
			+ " AND PRODUCTCODE IN %s"
			+ " AND ACTIVEFLAG = 'Y'";
	
	public static final String TL_ALLOC_QA_USERNAME = "";
	public static final String TL_ALLOC_QA_PASSWORD = "";
	
	
}
