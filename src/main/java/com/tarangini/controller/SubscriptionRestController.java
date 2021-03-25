package com.tarangini.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.DuplicateSubscriptionException;
import com.tarangini.exception.InvalidSubscriberDetailsException;
import com.tarangini.exception.InvalidSubscriptionDetailsException;
import com.tarangini.exception.SubscriptionNotFoundException;
import com.tarangini.model.SubscriberModel;
import com.tarangini.model.SubscriptionModel;
import com.tarangini.service.ISubscriptionService;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin
public class SubscriptionRestController {

	@Autowired
	private ISubscriptionService subscriptionService;
	
	
	@GetMapping("/{subscriptionId}")
	public ResponseEntity<SubscriptionModel> getById(@PathVariable("subscriptionId")Long subscriptionId) throws SubscriptionNotFoundException{
		return ResponseEntity.ok(subscriptionService.getById(subscriptionId));
	}
	
	@PostMapping
	public ResponseEntity<SubscriptionModel> createSubscription(
			@RequestBody @Valid SubscriptionModel subscriptionModel, 
			BindingResult result) throws InvalidSubscriptionDetailsException, DuplicateSubscriptionException  {
		
		if (result.hasErrors()) {
			throw new InvalidSubscriptionDetailsException(GlobalExceptionHandler.messageFrom(result));
		}
		
		return ResponseEntity.ok(subscriptionService.add(subscriptionModel));
	}	
	
	@PatchMapping("/{subscriptionId}/unsubscribe")
	public ResponseEntity<SubscriptionModel> unsubscribe(@PathVariable("subscriptionId")Long subscriptionId) throws SubscriptionNotFoundException{
		return ResponseEntity.ok(subscriptionService.unsubscribe(subscriptionId));
	}	
	
	@PatchMapping("/{subscriptionId}/renew")
	public ResponseEntity<SubscriptionModel> renew(@PathVariable("subscriptionId")Long subscriptionId) throws SubscriptionNotFoundException{
		return ResponseEntity.ok(subscriptionService.renew(subscriptionId));
	}	
}
