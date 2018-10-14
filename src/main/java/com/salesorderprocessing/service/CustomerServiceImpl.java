package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Customer;
import com.salesorderprocessing.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> OrderOptional = customerRepository.findById(id);
        if (OrderOptional.isPresent()) {
            return OrderOptional.get();
        }
        return null;
    }

    @Override
    public Customer saveOrUpdate(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<Customer> OrderOptional = customerRepository.findById(id);
        if (OrderOptional.isPresent()) customerRepository.deleteById(id);
    }

    // there is a better way to refactor this if ..? something ..to find out
    public Customer findByReference(String reference) {
        if (!customerRepository.findCustomerByCustReference(reference).equals(null)) {
            return customerRepository.findCustomerByCustReference(reference);
        }
        return null;
    }

}
