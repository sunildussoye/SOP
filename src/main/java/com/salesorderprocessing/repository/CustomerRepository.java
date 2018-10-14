package com.salesorderprocessing.repository;

import com.salesorderprocessing.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>  {

    Customer findCustomerByCustReference(String reference);

    //CustomerOrder outstandingOrder(String reference);


}
