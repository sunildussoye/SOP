package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "Report for oustanding Order for a customer")
public class CustomerOrder {

    private Customer customer;
    private List<OrderHeader> orderHeaders = new ArrayList<>();
    private Double OutstandingOrders;
    private Double OutstandingAmount;


}
