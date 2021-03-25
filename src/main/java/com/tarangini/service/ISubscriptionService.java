package com.tarangini.service;

import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.DuplicateSubscriptionException;
import com.tarangini.exception.InvalidSubscriptionDetailsException;
import com.tarangini.exception.SubscriptionNotFoundException;
import com.tarangini.model.SubscriptionModel;

public interface ISubscriptionService {	
	SubscriptionModel getById(Long id) throws SubscriptionNotFoundException;
	SubscriptionModel unsubscribe(Long id) throws SubscriptionNotFoundException;
	SubscriptionModel renew(Long id) throws SubscriptionNotFoundException;
	SubscriptionModel add(SubscriptionModel subscriptionModel) throws DuplicateSubscriptionException;
}
