package com.salesorderprocessing.repository;

import com.salesorderprocessing.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderHeader,Integer> {

    @Query(value = "select * from order_header where order_header.order_num = ?1 ",nativeQuery = true)
    List<OrderHeader> orderList(String id);
}
