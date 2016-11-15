/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParmEntityDTO;
import com.homedepot.mm.po.allocationteamdata.exception.BayParmNotFoundException;

/**
 * @author axd8472
 *
 */
public interface BayParmService {

	public List<BayParmEntityDTO> getBayParm(final String locationId, final String activeFlag) throws BayParmNotFoundException;

}
