package com.tarangini.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tarangini.entity.PackageEntity;
import com.tarangini.entity.SubscriberEntity;
import com.tarangini.entity.SubscriptionEntity;
import com.tarangini.entity.SubscriptionTerm;
import com.tarangini.model.PackageModel;
import com.tarangini.model.SubscriberModel;
import com.tarangini.model.SubscriptionModel;
import com.tarangini.repo.PackageRepo;
import com.tarangini.repo.SubscriberRepo;

@Service
public class EMParser {

	@Autowired
	private PackageRepo packageRepo;
	
	@Autowired
	private SubscriberRepo subscriberRepo;

	public SubscriptionModel parse(SubscriptionEntity source) {
		return source==null?null:
			new SubscriptionModel(source.getSubscriptionId(), 
					source.getPackaze().getPackageCode(), 
					source.getSubscriber().getSubscriberId(), 
					source.getDateValidFrom(), 
					source.getDateValidTo(),String.valueOf(source.getTerm()), 
					source.getFee(),source.getDateValidTo().isAfter(LocalDate.now())?"ACTIVE":"CLOSED",
					source.getPackaze().getDescription(),
					source.getPackaze().getTitle());
	}
	
	public SubscriptionEntity parse(SubscriptionModel source) {
		return source==null?null:
			new SubscriptionEntity(source.getSubscriptionId(), 
					packageRepo.findById(source.getPackageCode()).orElse(null), 
					subscriberRepo.findById(source.getSubscriberId()).orElse(null), 
					source.getDateValidFrom(), 
					source.getDateValidTo(),SubscriptionTerm.valueOf(source.getTerm()), 
					source.getFee());
	}

	public PackageEntity parse(PackageModel source) {
		return source==null?null:
			new PackageEntity(source.getPackageCode(),source.getTitle(),
					source.getDescription(),source.getMonthlyRent());
	}
	
	public PackageModel parse(PackageEntity source) {
		return source==null?null:
			new PackageModel(source.getPackageCode(),source.getTitle(),
					source.getDescription(),source.getMonthlyRent());
	}		

	public SubscriberEntity parse(SubscriberModel source) {
		return source==null?null:
			new SubscriberEntity(source.getSubscriberId(), source.getFullName(), source.getDateOfRegistration(), source.getMobileNumber());
	}
	
	public SubscriberModel parse(SubscriberEntity source) {
		return source==null?null:
			new SubscriberModel(source.getSubscriberId(), source.getFullName(), source.getDateOfRegistration(), source.getMobileNumber());
	}
}
