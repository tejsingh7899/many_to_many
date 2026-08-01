package com.tcs.erp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Services {
	
	@Id
	private Integer serviceId;

	private String serviceName;

	private Integer serviceCost;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(Integer serviceCost) {
		this.serviceCost = serviceCost;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Services services = (Services) o;
		return Objects.equals(serviceId, services.serviceId) && Objects.equals(serviceName, services.serviceName) && Objects.equals(serviceCost, services.serviceCost);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceId, serviceName, serviceCost);
	}
}