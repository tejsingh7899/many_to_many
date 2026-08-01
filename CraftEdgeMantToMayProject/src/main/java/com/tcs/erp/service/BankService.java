package com.tcs.erp.service;

import com.tcs.erp.dto.CustomerDTO;
import com.tcs.erp.exception.CEAException;

import java.util.List;

public interface BankService {
	public Integer addCustomerAndService(CustomerDTO customerDTO) throws CEAException;
	public void addExistingServiceToExistingCustomer(Integer customerId,List<Integer> serviceIds) throws CEAException;
	public void deallocateServiceForExistingCustomer(Integer customerId,List<Integer> serviceIds) throws CEAException;
}