package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Delivery;
import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Iterable<Delivery> listAll() {
        return null;
    }

    @Override
    public Delivery getById(Integer id) {
        return null;
    }

    @Override
    public Delivery saveOrUpdate(Delivery entity) {
        return deliveryRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Delivery findFirstByOrderHeader(OrderHeader orderHeader) {
        return deliveryRepository.findFirstByOrderHeader(orderHeader);
    }
}
