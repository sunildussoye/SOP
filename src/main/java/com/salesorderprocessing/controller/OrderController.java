package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.service.OrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    private OrderHeaderService orderHeaderService;

    @Autowired
    public OrderController(OrderHeaderService orderService) {
        this.orderHeaderService = orderService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<OrderHeader> getAllOrders() {
        return this.orderHeaderService.listAll();
    }
}
