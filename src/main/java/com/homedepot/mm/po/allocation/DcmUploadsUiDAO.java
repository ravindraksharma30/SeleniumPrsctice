package com.homedepot.mm.po.allocation;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DcmUploadsUiDAO {
	
	private static final Logger log = LoggerFactory.getLogger(DcmUploadsUiDAO.class);
	private Connection conn;
	
	public DcmUploadsUiDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:teradata://dcmqa.homedepot.com/LOGMECH=LDAP", "_SVC_DFUPLD", "pA55w0rd_upld");
			log.info("**** Established Connection: " + conn.toString());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TABLE_A");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}