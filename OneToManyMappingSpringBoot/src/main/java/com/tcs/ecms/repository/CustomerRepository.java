package com.tcs.ecms.repository;

import com.tcs.ecms.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
