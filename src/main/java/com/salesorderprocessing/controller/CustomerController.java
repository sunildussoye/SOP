package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.Customer;
import com.salesorderprocessing.exception.UserNotFoundException;
import com.salesorderprocessing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        //use DTO
        //use pagination
        return this.customerService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer cId) {

        Customer c = customerService.getById(cId);
        if (c == null) {
            throw new UserNotFoundException("id" + cId);
        }
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Integer cId) {

        Customer c = customerService.getById(cId);
        //move this check in the service and use Exception handler
        if (c == null) {
            throw new UserNotFoundException("id" + cId);
        }
        //should return ACCEPTED(202) not OK(200)
        customerService.delete(cId);
    }

    // @Valid = validation on the object
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer client) {
       /* Customer savedClient = customerService.saveOrUpdate(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId()).toUri();
        return ResponseEntity.created(location).build();*/

       client = customerService.saveOrUpdate(client);
       return ResponseEntity.created()
    }

}
