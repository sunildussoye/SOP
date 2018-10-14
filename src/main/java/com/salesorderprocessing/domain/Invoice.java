package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Invoice details for customers")

public class Invoice extends DomainBaseImpl {

    private String invoiceReference;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<OrderHeader> orderHeader = new ArrayList<>();

    @OneToMany
    private List<OrderDetail> orderDetail = new ArrayList<>();

    private Double invoiceTotal;

    public void addOrderToInvoice(OrderHeader order) {
        orderHeader.add(order);
    }

    public void addorderlinesToInvoice(OrderDetail odetail) {
        orderDetail.add(odetail);
    }

    // calculate invoice Total for Customer
    // loop though lines Qty * price from product

    /**
     public void addToInvoice(Double invoiceValue) {
     //System.out.println("addToInvoice" + invoiceValue + "check value " + (invoiceValue != 0));
     try{
     if (invoiceValue != 0 ) {
     this.setInvoiceTotal(this.getInvoiceTotal() + invoiceValue);
     System.out.println("invoice total" + invoiceTotal);
     }
     }
     catch (NullPointerException e) {
     // need to add our exception handling
     System.out.println("invoice total" + e.getMessage() + "invoice value " + invoiceValue );

     }
     }
     */
}
