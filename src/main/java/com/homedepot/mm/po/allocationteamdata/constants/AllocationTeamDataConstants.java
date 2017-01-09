/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.constants;

import java.math.BigDecimal;

/**
 * Defines constants for this project ApplicationTeamData.
 * 
 * @author gxk8870
 *
 */
public class AllocationTeamDataConstants {

	/**
	 * 
	 */
	public static final BigDecimal THREE = new BigDecimal("3");
	/**
	 * 
	 */
	public static final String TIMEZONE_STR = "America/New_York";

	/**
	 * 
	 */
	public static final String ALLOCATE_PATH = "/createAllocation";
	/**
	 * 
	 */
	public static final String ALLOCATION_ON_BOARD_PATH = "/findAllocationOnBoard";
	/**
	 * 
	 */
	public static final String BAY_PARM_PATH = "/findBayParm";
	/**
	 * 
	 */
	public static final String OVERAGE_DAYS_PATH = "/findOverageDay";
	/**
	 * 
	 */
	public static final String PEGGED_ORDER_PATH = "/findPeggedOrder";
	/**
	 * 
	 */
	public static final String SDC_TARGET_INVENTORY_PATH = "/findSDCTargetInventory";
	/**
	 * 
	 */
	public static final String ERROR_INVALID_QUERY = "allocationteamdata.invalid.queryParameter";

}
