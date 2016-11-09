package com.homedepot.mm.po.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homedepot.mm.po.dao.DcmUploadsUiDAO;

import java.sql.PreparedStatement;

/**
 * Provides utility methods for performing actions within the project.
 * @author gxk8870
 *
 */
public class AllocationTeamDataUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DcmUploadsUiDAO.class);

	/**
	 * Closes a Connection, PreparedStatement, and ResultSet if they aren't already null.
	 * @param conn A Connection object to close.
	 * @param stmt A PreparedStatement object to close.
	 * @param rs A ResultSet object to close.
	 */
	public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOGGER.warn("Error closing Connection", e);
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				LOGGER.warn("Error closing PreparedStatement", e);
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.warn("Error closing ResultSet", e);
			}
		}
	}
}
