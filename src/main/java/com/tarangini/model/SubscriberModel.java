package com.tarangini.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;



public class SubscriberModel {
	
	private Long subscriberId;
	
	@NotNull(message="full name cannot be null")	
	@NotBlank(message="full name cannot be blank")
	private String fullName;
	
	@NotNull(message="registration date cannot be null")
	@PastOrPresent(message="registration date cannot be in future")
	private LocalDate dateOfRegistration;
	
	@NotNull(message="mobile number cannot be null")
	@Pattern(regexp = "[1-9][0-9]{9}")
	private String mobileNumber;

	public SubscriberModel() {
		/* default constructor */
	}

	public SubscriberModel(Long subscriberId, String fullName, LocalDate dateOfRegistration, String mobileNumber) {
		super();
		this.subscriberId = subscriberId;
		this.fullName = fullName;
		this.dateOfRegistration = dateOfRegistration;
		this.mobileNumber = mobileNumber;
	}

	public Long getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfRegistration == null) ? 0 : dateOfRegistration.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscriberModel other = (SubscriberModel) obj;
		if (dateOfRegistration == null) {
			if (other.dateOfRegistration != null)
				return false;
		} else if (!dateOfRegistration.equals(other.dateOfRegistration))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", fullName=" + fullName + ", dateOfRegistration="
				+ dateOfRegistration + ", mobileNumber=" + mobileNumber + "]";
	}
}
