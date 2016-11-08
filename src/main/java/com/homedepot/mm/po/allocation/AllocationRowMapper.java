/**
 * 
 */
package com.homedepot.mm.po.allocation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author axd8472
 * @param <T>
 *
 */
@Component
public class AllocationRowMapper implements RowMapper<BayParm> {
	private List<BayParm> bayParmList;

	@Override
	public BayParm mapRow(ResultSet rs, int rowNum) throws SQLException {
		BayParm bayParm = new BayParm();

		bayParm.setTLD_ALLOC_ONBRD_PARM_ID(rs.getInt("TLD_ALLOC_ONBRD_PARM_ID"));
		bayParm.setTLD_ALLOC_PARM_TYP_CD(rs.getInt("TLD_ALLOC_PARM_TYP_CD"));
		bayParm.setPARM_ITEM_ID(rs.getInt("PARM_ITEM_ID"));
		bayParm.setPARM_LOC_ID(rs.getInt("PARM_LOC_ID"));
		bayParm.setPARM_LOC_TYP_CD(rs.getString("PARM_LOC_TYP_CD"));
		bayParm.setPARM_INTG_VAL(rs.getInt("PARM_INTG_VAL"));
		bayParm.setACTV_FLG(rs.getString("ACTV_FLG"));

		bayParmList.add(bayParm);
		return bayParm;
	}

}
