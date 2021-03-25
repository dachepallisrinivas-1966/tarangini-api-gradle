package com.tarangini.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tarangini.entity.SubscriptionEntity;

@Repository
public interface SubscriptionRepo extends JpaRepository<SubscriptionEntity, Long>{
	
	@Modifying
	@Query("update SubscriptionEntity s set s.dateValidTo=:toDate where s.subscriptionId=:id")
	int changeSubscriptionDateValidTo(LocalDate toDate,Long id);	
}
