package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderHeaderServiceImpl implements OrderHeaderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<OrderHeader> listAll() {

        return orderRepository.findAll();
    }

    @Override
    public OrderHeader getById(Integer id) {
        Optional<OrderHeader> orderHeader = orderRepository.findById(id);
        if (orderHeader.isPresent()) {
            return orderHeader.get();
        }
        return null;
    }

    @Override
    public OrderHeader saveOrUpdate(OrderHeader entity) {
        return orderRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<OrderHeader> orderHeader = orderRepository.findById(id);
        if (orderHeader.isPresent()) orderRepository.deleteById(id);
    }

}
