package com.tarangini.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subscribers")
public class SubscriberEntity {
	@Id
	@Column(name="subscriber_id")
	@GeneratedValue
	private Long subscriberId;
	
	@Column(name="full_name", nullable=false)
	private String fullName;
	
	@Column(name="date_of_registration", nullable=false)
	private LocalDate dateOfRegistration;

	@Column(name="mobile_number", nullable=false)
	private String mobileNumber;

	@OneToMany(mappedBy="subscriber")
	private Set<SubscriptionEntity> subscriptions;
	
	public SubscriberEntity() {
		/* default constructor */
	}

	public SubscriberEntity(Long subscriberId, String fullName, LocalDate dateOfRegistration, String mobileNumber) {
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

	public Set<SubscriptionEntity> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<SubscriptionEntity> subscriptions) {
		this.subscriptions = subscriptions;
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
		SubscriberEntity other = (SubscriberEntity) obj;
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
