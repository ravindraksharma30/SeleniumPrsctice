/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.BayParmNotFoundException;

/**
 * @author axd8472
 *
 */
public interface BayParmService {

	public List<BayParm> getBayParm(final String locationId, final String activeFlag) throws BayParmNotFoundException;

}
