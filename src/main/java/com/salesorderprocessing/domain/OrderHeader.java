package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@ApiModel(description = "Orders for customers")

public class OrderHeader extends DomainBaseImpl{

    private String orderNum;
    private OrderStatus orderStatus;

    @OneToOne
    private Customer customer ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderHeader", orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    private LocalDate orderDate;
    private LocalDate orderShipped;

    public void addToOrderDetails(OrderDetail orderDetail){
        orderDetail.setOrderHeader(this);
        orderDetails.add(orderDetail);
    }
    public void removeOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrderHeader(null);
        orderDetails.remove(orderDetail);
    }


}
