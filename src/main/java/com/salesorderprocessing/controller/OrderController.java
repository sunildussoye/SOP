package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.service.OrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order/id")
@RestController
public class OrderController {

    private OrderHeaderService orderHeaderService;

    @Autowired
    public OrderController(OrderHeaderService orderService) {
        this.orderHeaderService = orderService;
    }

    //pagination ?
    @GetMapping
    public Iterable<OrderHeader> getAllOrders() {
        return this.orderHeaderService.listAll();
    }
}
