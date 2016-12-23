package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;

@Transactional
@Repository("AllocationHeaderRepository")
public interface AllocationHeaderRepository extends JpaRepository<AllocationHeader, Integer> {

}
