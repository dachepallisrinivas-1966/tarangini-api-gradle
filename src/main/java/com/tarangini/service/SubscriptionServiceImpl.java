package com.tarangini.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarangini.entity.SubscriptionEntity;
import com.tarangini.entity.SubscriptionTerm;
import com.tarangini.exception.DuplicateSubscriptionException;
import com.tarangini.exception.InvalidSubscriptionDetailsException;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.exception.SubscriptionNotFoundException;
import com.tarangini.model.SubscriptionModel;
import com.tarangini.repo.SubscriptionRepo;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;

	@Autowired
	private EMParser parser;

	public SubscriptionServiceImpl() {
		
	}
	
	public SubscriptionServiceImpl(SubscriptionRepo subscriptionRepo) {
		super();
		this.subscriptionRepo = subscriptionRepo;
		this.parser = new EMParser();
	}

	@Override
	public SubscriptionModel getById(Long id) throws SubscriptionNotFoundException {

		if (!subscriptionRepo.existsById(id))
			throw new SubscriptionNotFoundException("No Such Subscription Found");

		return parser.parse(subscriptionRepo.findById(id).get());
	}

	@Transactional
	@Override
	public SubscriptionModel unsubscribe(Long id) throws SubscriptionNotFoundException {

		if (!subscriptionRepo.existsById(id))
			throw new SubscriptionNotFoundException("No Such Subscription Found");

		subscriptionRepo.changeSubscriptionDateValidTo(LocalDate.now(), id);
		return getById(id);
	}

	@Transactional
	@Override
	public SubscriptionModel renew(Long id) throws SubscriptionNotFoundException {

		SubscriptionEntity entity = subscriptionRepo.findById(id).orElse(null);
		if (entity == null)
			throw new SubscriptionNotFoundException("No Such Subscription Found");

		LocalDate renewalDate = null;
		if (entity.getTerm() == SubscriptionTerm.MONTHLY)
			renewalDate = entity.getDateValidTo().plusMonths(1);
		else
			renewalDate = entity.getDateValidTo().plusYears(1);

		subscriptionRepo.changeSubscriptionDateValidTo(renewalDate, id);

		return getById(id);
	}

	@Transactional
	@Override
	public SubscriptionModel add(SubscriptionModel subscriptionModel) throws DuplicateSubscriptionException{
		if(subscriptionRepo.existsById(subscriptionModel.getSubscriptionId()))
			throw new DuplicateSubscriptionException("Subscription with the given id already exists");
		
		
		return parser.parse(subscriptionRepo.save(parser.parse(subscriptionModel)));
	}

}
