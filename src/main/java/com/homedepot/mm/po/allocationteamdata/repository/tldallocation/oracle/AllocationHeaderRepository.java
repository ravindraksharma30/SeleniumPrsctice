package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;

@Transactional
public interface AllocationHeaderRepository extends JpaRepository<AllocationHeader, Integer>{

}
