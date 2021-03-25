package com.tarangini.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "packages")
public class PackageEntity {
	@Id
	@Column(name="package_code")
	private String packageCode;
	
	@Column(name="title", nullable=false, unique=true)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="monthly_rent", nullable=false)
	private Double monthlyRent;

	@OneToMany(mappedBy="packaze")
	private Set<SubscriptionEntity> subscriptions;
	
	public PackageEntity() { 
		/* default constructor */
	}

	public PackageEntity(String packageCode, String title, String description, Double monthlyRent) {
		super();
		this.packageCode = packageCode;
		this.title = title;
		this.description = description;
		this.monthlyRent = monthlyRent;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(Double monthlyRent) {
		this.monthlyRent = monthlyRent;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((monthlyRent == null) ? 0 : monthlyRent.hashCode());
		result = prime * result + ((packageCode == null) ? 0 : packageCode.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PackageEntity other = (PackageEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (monthlyRent == null) {
			if (other.monthlyRent != null)
				return false;
		} else if (!monthlyRent.equals(other.monthlyRent))
			return false;
		if (packageCode == null) {
			if (other.packageCode != null)
				return false;
		} else if (!packageCode.equals(other.packageCode))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Package [packageCode=" + packageCode + ", title=" + title + ", description=" + description
				+ ", monthlyRent=" + monthlyRent + "]";
	}
	
}
