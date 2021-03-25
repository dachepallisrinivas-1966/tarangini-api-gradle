package com.tarangini.model;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class SubscriptionModel  {
	
	private Long subscriptionId;
	
	@NotNull(message="package code cannot be null")
	@NotBlank(message="package code cannot be blank")
	private String packageCode;
	
	@NotNull(message="subscriber id cannot be null")
	private Long subscriberId;
	
	@NotNull(message="from date cannot be null")
	@PastOrPresent(message="from date cannot be in future")
	private LocalDate dateValidFrom;
	
	@NotNull(message="to date cannot be null")
	@FutureOrPresent(message="to date cannot be in past")
	private LocalDate dateValidTo;
	
	@NotNull(message="term cannot be null")
	@NotBlank(message="term cannot be blank")
	private String term;
	
	@NotNull(message="fee cannot be null")
	@Min(value=0,message="fee cannot be negative")
	private Double fee;
	
	private String status;
	private String description;
	private String packageTitle;
	
	public SubscriptionModel() {
		/* default constructor */
	}


	public SubscriptionModel(Long subscriptionId, @NotNull(message = "") @NotBlank(message = "") String packageCode,
			@NotNull(message = "") Long subscriberId,
			@NotNull(message = "") @PastOrPresent(message = "") LocalDate dateValidFrom,
			@NotNull(message = "") @FutureOrPresent(message = "") LocalDate dateValidTo,
			@NotNull(message = "") @NotBlank(message = "") String term,
			@NotNull(message = "") @Min(value = 0, message = "") Double fee,String status,String description,String packageTitle) {
		super();
		this.subscriptionId = subscriptionId;
		this.packageCode = packageCode;
		this.subscriberId = subscriberId;
		this.dateValidFrom = dateValidFrom;
		this.dateValidTo = dateValidTo;
		this.term = term;
		this.fee = fee;
		this.status=status;
		this.description=description;
		this.packageTitle=packageTitle;
	}


	public Long getSubscriptionId() {
		return subscriptionId;
	}


	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}


	public String getPackageCode() {
		return packageCode;
	}


	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}


	public Long getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}


	public LocalDate getDateValidFrom() {
		return dateValidFrom;
	}


	public void setDateValidFrom(LocalDate dateValidFrom) {
		this.dateValidFrom = dateValidFrom;
	}


	public LocalDate getDateValidTo() {
		return dateValidTo;
	}


	public void setDateValidTo(LocalDate dateValidTo) {
		this.dateValidTo = dateValidTo;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public Double getFee() {
		return fee;
	}


	public void setFee(Double fee) {
		this.fee = fee;
	}

	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateValidFrom == null) ? 0 : dateValidFrom.hashCode());
		result = prime * result + ((dateValidTo == null) ? 0 : dateValidTo.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((packageCode == null) ? 0 : packageCode.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		result = prime * result + ((subscriptionId == null) ? 0 : subscriptionId.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		SubscriptionModel other = (SubscriptionModel) obj;
		if (dateValidFrom == null) {
			if (other.dateValidFrom != null)
				return false;
		} else if (!dateValidFrom.equals(other.dateValidFrom))
			return false;
		if (dateValidTo == null) {
			if (other.dateValidTo != null)
				return false;
		} else if (!dateValidTo.equals(other.dateValidTo))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		if (packageCode == null) {
			if (other.packageCode != null)
				return false;
		} else if (!packageCode.equals(other.packageCode))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		if (subscriptionId == null) {
			if (other.subscriptionId != null)
				return false;
		} else if (!subscriptionId.equals(other.subscriptionId))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SubscriptionModel [subscriptionId=" + subscriptionId + ", packageCode=" + packageCode
				+ ", subscriberId=" + subscriberId + ", dateValidFrom=" + dateValidFrom + ", dateValidTo=" + dateValidTo
				+ ", term=" + term + ", fee=" + fee + "]";
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPackageTitle() {
		return packageTitle;
	}


	public void setPackageTitle(String packageTitle) {
		this.packageTitle = packageTitle;
	}

	
}
