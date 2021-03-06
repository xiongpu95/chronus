package com.qihoo.finance.chronus.storage.h2.plugin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qihoo.finance.chronus.storage.h2.plugin.entity.ClusterH2Entity;

/**
 * @author zhangsi-pc.
 * @date 2019/9/21.
 */
@Repository
public interface ClusterJpaRepository extends JpaRepository<ClusterH2Entity, String> {
	
	@Query("select c from ClusterH2Entity c where c.cluster =:cluster")
	ClusterH2Entity findFirstByAndCluster(@Param("cluster") String cluster);

	@Modifying
	@Query(value = "update ClusterH2Entity e set e.clusterDesc=:newDesc where e.id =:id")
	void updateEnvDesc(@Param("id") String id, @Param("newDesc") String desc);

	@Transactional
	@Modifying
	@Query(value = "delete from ClusterH2Entity u where u.cluster = ?1")
	void deleteByCluster(String cluster);
}
