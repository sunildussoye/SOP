package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.Address;
import com.salesorderprocessing.domain.Customer;
import com.salesorderprocessing.service.CustomerService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService ;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    static List<Customer> customers = new ArrayList<>() ;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        /** header issue with CorsFilter
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .addFilters(new CorsFilter())  // not required
                .build();
        **/
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .build();

    }

    @BeforeClass
    public static void DataSetup(){

        Address address = new Address();
        address.setAddressLine1("65 Idsworth Rd");
        address.setAddressLine2("South Yorkshire");
        address.setAddressLine2("Sheffield");
        address.setCountry("South YorkShire");
        address.setPostCode("S5 6UN");
        address.setCountry("UK");
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Mike");
        customer.setLastName("Allan");
        customer.setAddressType("C");
        customer.setCustomerAddress(address);
        customer.setEmail("Allan@donkey.com");
        customer.setPhoneNumber("305.333.0101");

        Address address1 = new Address();
        address1.setAddressLine1("Donnington Rd");
        address1.setAddressLine2("North Yorkshire");
        address1.setAddressLine2("York");
        address1.setCountry("North YorkShire");
        address1.setPostCode("YO424LT");
        address1.setCountry("UK");
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Roy");
        customer1.setLastName("Stacey");
        customer1.setCustomerAddress(address1);
        customer1.setAddressType("D");
        customer1.setEmail("Stacey@donkey.com");
        customer1.setPhoneNumber("0114678898");

        customers.add(customer);
        customers.add(customer1);
    }

    @Test
    public void getAllCustomers() throws Exception {

        when(customerService.listAll()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        System.out.println("array size " + customers.size() + " id =" + customers.get(0).getId());
        assertEquals(customers.size(),2);

        assertEquals("zip code is S5 6UN","S5 6UN",customers.get(0).getCustomerAddress().getPostCode());

        //Verify that the listAll() method of the clientService is invoked exactly once.
        verify(customerService, times(1)).listAll();

        //Verify that after the response, no more interactions are made to the customerService
        verifyNoMoreInteractions(customerService);
    }

    @Test
    public void getCustomerById() throws Exception {

        Integer id = 1 ;

        when(customerService.getById(id)).thenReturn(customers.get(0));

        mockMvc.perform(get("/customer/id/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.lastName").value("Allan"));
    }

    @Test
    public void deleteClient() {

    }

    @Test
    public void saveOrUpdate() throws Exception {
        Address newAddress = new Address();
        newAddress.setAddressLine1("65 Idsworth Rd");
        newAddress.setAddressLine2("South Yorkshire");
        newAddress.setAddressLine2("Sheffield");
        newAddress.setCountry("South YorkShire");
        newAddress.setPostCode("S5 6UN");
        newAddress.setCountry("UK");

        Customer newCustomer = new Customer();
        newCustomer.setId(4);
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Vegas");
        newCustomer.setAddressType("R");
        newCustomer.setCustomerAddress(newAddress);
        newCustomer.setEmail("Johnny@arse.com");
        newCustomer.setPhoneNumber("07905678999");

        when(customerService.saveOrUpdate(newCustomer)).thenReturn(newCustomer);

        mockMvc.perform(post("/client/create"));

        assertEquals("4", newCustomer.getId().toString());
        assertEquals("John", newCustomer.getFirstName());

        verifyNoMoreInteractions(customerService);
    }

}