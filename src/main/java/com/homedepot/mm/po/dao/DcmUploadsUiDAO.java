package com.homedepot.mm.po.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homedepot.mm.po.constant.AllocationTeamDataConstants;
import com.homedepot.mm.po.dto.BayParmDTO;
import com.homedepot.mm.po.util.AllocationTeamDataUtil;

public class DcmUploadsUiDAO {
	
	@Autowired
	private static DataSource dataSource;
	
	private static final Logger log = LoggerFactory.getLogger(DcmUploadsUiDAO.class);
	public static HashMap<String, BayParmDTO> bayParmMap = null;

	public static HashMap<String, BayParmDTO> getBayParmMap(String locationID, List<Integer> skuList) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//JdbcTemplate jdbc = null;
		
		try {
			//get a connection to the database, run a query for the bay param data, then get the results
			conn = DriverManager.getConnection("jdbc:teradata://dcmqa.homedepot.com/LOGMECH=LDAP", AllocationTeamDataConstants.TL_ALLOC_QA_USERNAME, AllocationTeamDataConstants.TL_ALLOC_QA_PASSWORD);
			stmt = conn.prepareStatement(String.format(AllocationTeamDataConstants.READ_TLD_ALLOC_ONBRD_PARM, locationID, skuList.toString().replace("[", "(").replace("]", ")")));
			rs = stmt.executeQuery();
			
			//jdbc = new JdbcTemplate(dataSource);
			
			bayParmMap = new HashMap<>();
			
			//loop through the results and add them to the list
			while(rs.next()) {
				BayParmDTO bayParm = new BayParmDTO();
			
				bayParm.setUPLOADID(rs.getInt("UPLOADID"));
				bayParm.setSEQUENCENUMBER(rs.getInt("SEQUENCENUMBER"));
				bayParm.setLOCATIONID(rs.getInt("LOCATIONID"));
				bayParm.setPRODUCTCODE(rs.getString("PRODUCTCODE"));
				bayParm.setBAY_PARM_VAL(rs.getDouble("BAY_PARM_VAL"));
				bayParm.setACTIVEFLAG(rs.getString("ACTIVEFLAG"));
				
				bayParmMap.put(rs.getString("PRODUCTCODE"), bayParm);
			}
	
			return bayParmMap;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			AllocationTeamDataUtil.closeAll(conn, stmt, rs);
		}
	}
}