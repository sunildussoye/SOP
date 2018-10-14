package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Delivery;
import com.salesorderprocessing.domain.OrderHeader;

public interface DeliveryService extends CRUDService<Delivery>{

    Delivery findFirstByOrderHeader(OrderHeader orderHeader);
}
