package com.tcs.ecms.service;

import com.tcs.ecms.dto.CustomerDTO;
import com.tcs.ecms.exception.HDFCBankException;

import java.util.List;

public interface CardCustomerService {

    public CustomerDTO getCustomerDetails(Integer customerId) throws HDFCBankException;
    public byte[] generateCustomerReport(List<CustomerDTO> customerDTO) throws HDFCBankException;
}
