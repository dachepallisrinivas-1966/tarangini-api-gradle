package com.tarangini.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscriptions")
public class SubscriptionEntity implements Comparable<SubscriptionEntity> {
	@Id
	@Column(name="subscription_id")
	@GeneratedValue
	private Long subscriptionId;
	
	@ManyToOne
	@JoinColumn(name="package_code")
	private PackageEntity packaze;
	
	@ManyToOne
	@JoinColumn(name="subscriber_id")
	private SubscriberEntity subscriber;
	
	@Column(name="date_valid_from", nullable=false)
	private LocalDate dateValidFrom;
	
	@Column(name="date_valid_to", nullable=false)
	private LocalDate dateValidTo;
	
	@Column(name="term", nullable=false)
	@Enumerated(value=EnumType.STRING)
	private SubscriptionTerm term;
	
	@Column(name="fee", nullable=false)
	private Double fee;
	
	public SubscriptionEntity() {
		/* default constructor */
	}

	public SubscriptionEntity(Long subscriptionId, PackageEntity packaze, SubscriberEntity subscriber, LocalDate dateValidFrom,
			LocalDate dateValidTo, SubscriptionTerm term, Double fee) {
		super();
		this.subscriptionId = subscriptionId;
		this.packaze = packaze;
		this.subscriber = subscriber;
		this.dateValidFrom = dateValidFrom;
		this.dateValidTo = dateValidTo;
		this.term = term;
		this.fee = fee;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public PackageEntity getPackaze() {
		return packaze;
	}

	public void setPackaze(PackageEntity packaze) {
		this.packaze = packaze;
	}

	public SubscriberEntity getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(SubscriberEntity subscriber) {
		this.subscriber = subscriber;
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

	public SubscriptionTerm getTerm() {
		return term;
	}

	public void setTerm(SubscriptionTerm term) {
		this.term = term;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateValidFrom == null) ? 0 : dateValidFrom.hashCode());
		result = prime * result + ((dateValidTo == null) ? 0 : dateValidTo.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
		result = prime * result + ((packaze == null) ? 0 : packaze.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		SubscriptionEntity other = (SubscriptionEntity) obj;
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
		if (packaze == null) {
			if (other.packaze != null)
				return false;
		} else if (!packaze.equals(other.packaze))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (subscriptionId == null) {
			if (other.subscriptionId != null)
				return false;
		} else if (!subscriptionId.equals(other.subscriptionId))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", packaze=" + packaze + ", subscriber=" + subscriber
				+ ", dateValidFrom=" + dateValidFrom + ", dateValidTo=" + dateValidTo + ", term=" + term + ", fee="
				+ fee + "]";
	}

	@Override
	public int compareTo(SubscriptionEntity other) {
		return this.subscriptionId.compareTo(other.subscriptionId);
	}

}
