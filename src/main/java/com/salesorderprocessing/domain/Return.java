package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
// Return - return - reserved word
@Table(name = "GoodReturned")
@ApiModel(description = "Goods returned by customers")
public class Return extends DomainBaseImpl{

    private String returnReference;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<OrderHeader> orderHeader = new ArrayList<>();

    // returning an item on the delivery list
    @OneToMany
    private List<Delivery> returns = new ArrayList<>();
    private Double returnTotal;

    public void setOrder(OrderHeader oh) {
        orderHeader.add(oh);
    }

    public void addToReturn(Delivery goodsrt) {
        returns.add(goodsrt);
    }

    // calculate return total
}
