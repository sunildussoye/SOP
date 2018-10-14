package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Customer;

public interface CustomerService extends CRUDService<Customer> {

    Customer findByReference(String reference);
}
