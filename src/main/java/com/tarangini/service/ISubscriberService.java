package com.tarangini.service;

import java.util.List;

import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.InvalidSubscriberDetailsException;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.model.SubscriberModel;
import com.tarangini.model.SubscriptionModel;

public interface ISubscriberService {	
	SubscriberModel getById(Long id) throws SubscriberNotFoundException;
	SubscriberModel getByMobileNumber(String mobileNumber) throws SubscriberNotFoundException;
	SubscriberModel add(SubscriberModel subscriberModel) throws DuplicateSubscriberException;
	SubscriberModel modify(SubscriberModel subscriberModel, Long id) throws SubscriberNotFoundException;
	List<SubscriptionModel> getAllSubscriptions(Long subscriberId) throws SubscriberNotFoundException;
}
