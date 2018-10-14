package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.Customer;
import com.salesorderprocessing.exception.UserNotFoundException;
import com.salesorderprocessing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Customer> getAllCustomers() {
        return this.customerService.listAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer cId) {

        Customer c = customerService.getById(cId);
        if (c == null) {
            throw new UserNotFoundException("id" + cId);
        }
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Integer cId) {

        Customer c = customerService.getById(cId);
        if (c == null) {
            throw new UserNotFoundException("id" + cId);
        }
        customerService.delete(cId);
    }

    // @Valid = validation on the object
    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer client) {
        Customer savedClient = customerService.saveOrUpdate(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
