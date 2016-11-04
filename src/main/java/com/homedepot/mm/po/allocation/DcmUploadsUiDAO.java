package com.homedepot.mm.po.allocation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homedepot.mm.po.dto.BayParmDTO;
import com.homedepot.mm.po.util.AllocationTeamDataUtil;
import com.homedepot.com.mm.po.constant.AllocationTeamDataConstants;

public class DcmUploadsUiDAO {
	
	private static final Logger log = LoggerFactory.getLogger(DcmUploadsUiDAO.class);
	public List<BayParmDTO> bayParmList;

	public DcmUploadsUiDAO() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:teradata://dcmqa.homedepot.com/LOGMECH=LDAP", "_SVC_DFUPLD", "pA55w0rd_upld");
			log.debug("**** Established Connection: " + conn.toString());
			stmt = conn.prepareStatement(String.format(AllocationTeamDataConstants.READ_TLD_ALLOC_ONBRD_PARM, 2, 5));
			rs = stmt.executeQuery();
			
			bayParmList = new ArrayList<>();
			
			while(rs.next()) {
				BayParmDTO bayParm = new BayParmDTO();
			
				bayParm.setTLD_ALLOC_ONBRD_PARM_ID(rs.getInt("TLD_ALLOC_ONBRD_PARM_ID"));
				bayParm.setTLD_ALLOC_PARM_TYP_CD(rs.getInt("TLD_ALLOC_PARM_TYP_CD"));
				bayParm.setPARM_ITEM_ID(rs.getInt("PARM_ITEM_ID"));
				bayParm.setPARM_LOC_ID(rs.getInt("PARM_LOC_ID"));
				bayParm.setPARM_LOC_TYP_CD(rs.getString("PARM_LOC_TYP_CD"));
				bayParm.setPARM_INTG_VAL(rs.getInt("PARM_INTG_VAL"));
				bayParm.setACTV_FLG(rs.getString("ACTV_FLG"));
				
				bayParmList.add(bayParm);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AllocationTeamDataUtil.closeAll(conn, stmt, rs);
		}
	}
}