package com.salesorderprocessing.domain;

import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;


@Data
public class DeliveryNoteMatching {

    @OneToOne
    private Customer customer;
    @OneToMany
    private List<OrderHeader> orderHeader;
    @OneToMany
    private List<OrderDetail> orderDetail;

    @OneToMany
    private List<Delivery> delivery;

    @OneToMany
    private List<Return> returns;

    private Boolean allMatch;

    private float discrepancy;

}
