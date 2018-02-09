package com.teracloud.platform.dao.teracloud;

import java.util.List;

import com.teracloud.platform.entity.teracloud.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NationDao extends JpaRepository<Nation, Integer> {

	@Query("from Nation n where n.code =:rLocation")
	Nation findByLocation(@Param("rLocation") String rLocation);
	
	@Query("from Nation n where n.parent =:parentId")
	List<Nation> findByParent(@Param("parentId") String parentId);
}
