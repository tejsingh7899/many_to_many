package com.tcs.erp.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name="emailid")
	private String emailId;

	private String name;

	private LocalDate dateOfBirth;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="customer_service", joinColumns=@JoinColumn(name="cust_id"), inverseJoinColumns=@JoinColumn(name="serv_id"))
	private Set<Services> bankServices;


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<Services> getBankServices() {
		return bankServices;
	}

	public void setBankServices(Set<Services> bankServices) {
		this.bankServices = bankServices;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(customerId, customer.customerId) && Objects.equals(emailId, customer.emailId) && Objects.equals(name, customer.name) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(bankServices, customer.bankServices);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, emailId, name, dateOfBirth, bankServices);
	}
}
