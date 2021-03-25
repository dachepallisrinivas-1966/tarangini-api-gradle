package com.tarangini.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarangini.entity.SubscriberEntity;
import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.model.SubscriberModel;
import com.tarangini.model.SubscriptionModel;
import com.tarangini.repo.SubscriberRepo;

@Service
public class SubscriberServiceImpl implements ISubscriberService {

	@Autowired
	private SubscriberRepo subscriberRepo;

	@Autowired
	private EMParser parser;

	
	public SubscriberServiceImpl() {
		
	}
	
	public SubscriberServiceImpl(SubscriberRepo subscriberRepo) {
		super();
		this.subscriberRepo = subscriberRepo;
		this.parser = new EMParser();
	}

	@Override
	public SubscriberModel getById(Long id) throws SubscriberNotFoundException {
		if (!subscriberRepo.existsById(id))
			throw new SubscriberNotFoundException("No subscriber found for the given id");
		return parser.parse(subscriberRepo.findById(id).get());
	}

	@Override
	public SubscriberModel getByMobileNumber(String mobileNumber) throws SubscriberNotFoundException{
		if (!subscriberRepo.existsByMobileNumber(mobileNumber))
			throw new SubscriberNotFoundException("No subscriber found for the given mobile number");
		return parser.parse(subscriberRepo.findByMobileNumber(mobileNumber));
	}

	@Transactional
	@Override
	public SubscriberModel add(SubscriberModel subscriberModel) throws DuplicateSubscriberException {

		if (subscriberModel != null) {
			if (subscriberRepo.existsById(subscriberModel.getSubscriberId())) {
				throw new DuplicateSubscriberException("Subscriber with this id already exists");
			}

			subscriberModel = parser.parse(subscriberRepo.save(parser.parse(subscriberModel)));
		}

		return subscriberModel;
	}

	@Transactional
	@Override
	public SubscriberModel modify(SubscriberModel subscriberModel, Long id) throws SubscriberNotFoundException {
		if (subscriberModel != null) {
			if (!subscriberRepo.existsById(id)) {
				throw new SubscriberNotFoundException("No Such Subscriber");
			}

			subscriberModel = parser.parse(subscriberRepo.save(parser.parse(subscriberModel)));
		}

		return subscriberModel;
	}

	@Override
	public List<SubscriptionModel> getAllSubscriptions(Long subscriberId) throws SubscriberNotFoundException {

		SubscriberEntity subscriber = subscriberRepo.findById(subscriberId).orElse(null);

		if (subscriber == null) {
			throw new SubscriberNotFoundException("No Such Subscriber");
		}

		return subscriber.getSubscriptions().stream().map(parser::parse).collect(Collectors.toList());
	}
}
