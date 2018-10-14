package com.salesorderprocessing.repository;

import com.salesorderprocessing.domain.Delivery;
import com.salesorderprocessing.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

    Delivery findFirstByOrderHeader(OrderHeader orderHeader);
}
