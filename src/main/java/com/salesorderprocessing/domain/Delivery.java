package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@ApiModel(description = "Deliveries made to the customer at his delivery address , one or more orders ")

public class Delivery extends DomainBaseImpl {

    private String deliveryReference;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<OrderHeader> orderHeader = new ArrayList<>();
    @OneToMany
    private List<OrderDetail> orderDetail = new ArrayList<>();
    private float deliveryTotal;

    public void addDeliveredGoods(OrderDetail oline) {
        orderDetail.add(oline);
    }

    public void addOrderToDelivery(OrderHeader oHeader) {
        orderHeader.add(oHeader);
    }



    // calculate delivery total for customer
    // can be gauged from orderline delivered

}
