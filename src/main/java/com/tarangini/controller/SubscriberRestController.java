package com.tarangini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarangini.exception.DuplicateSubscriberException;
import com.tarangini.exception.InvalidSubscriberDetailsException;
import com.tarangini.exception.SubscriberNotFoundException;
import com.tarangini.model.SubscriberModel;
import com.tarangini.model.SubscriptionModel;
import com.tarangini.service.ISubscriberService;

@RestController
@RequestMapping("/subscribers")
@CrossOrigin
public class SubscriberRestController {

	@Autowired
	private ISubscriberService subscriberService;
	
	@GetMapping("/{subscriberId}:[0-9]{1,5}")
	public ResponseEntity<SubscriberModel> getById(@PathVariable("subscriberId") Long id) throws SubscriberNotFoundException {
		return ResponseEntity.ok(subscriberService.getById(id));
	}
	
	@GetMapping("/{mobileNumber:[1-9][0-9]{9}}")
	public ResponseEntity<SubscriberModel> getByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) throws SubscriberNotFoundException {
		return ResponseEntity.ok(subscriberService.getByMobileNumber(mobileNumber));
	}
	
	@GetMapping("/{subscriberId}/subscriptions")
	public ResponseEntity<List<SubscriptionModel>> getAllSubscriptions(@PathVariable("subscriberId") Long id) throws SubscriberNotFoundException {
		return ResponseEntity.ok(subscriberService.getAllSubscriptions(id));
	}
	
	@PostMapping
	public ResponseEntity<SubscriberModel> createSubscriber(
			@RequestBody @Valid SubscriberModel subscriberModel, BindingResult result) throws InvalidSubscriberDetailsException, DuplicateSubscriberException {
		
		if (result.hasErrors()) {
			throw new InvalidSubscriberDetailsException(GlobalExceptionHandler.messageFrom(result));
		}
		
		return ResponseEntity.ok(subscriberService.add(subscriberModel));
	}
	
	@PutMapping("/{subscriberId}")
	public ResponseEntity<SubscriberModel> modifySubscriber(
			@PathVariable("subscriberId") Long id,
			@RequestBody @Valid SubscriberModel subscriberModel, 
			BindingResult result) throws InvalidSubscriberDetailsException, SubscriberNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidSubscriberDetailsException(GlobalExceptionHandler.messageFrom(result));
		}
		
		return ResponseEntity.ok(subscriberService.modify(subscriberModel,id));
	}
	
}
