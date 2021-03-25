package com.tarangini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarangini.entity.SubscriberEntity;

@Repository
public interface SubscriberRepo extends JpaRepository<SubscriberEntity, Long>{
	
	boolean existsByMobileNumber(String mobileNumber);
	SubscriberEntity findByMobileNumber(String mobileNumber);
	
}
