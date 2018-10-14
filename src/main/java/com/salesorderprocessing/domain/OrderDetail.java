package com.salesorderprocessing.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Data

@Setter
@ApiModel(description = "order lines for the customer/order")

public class OrderDetail extends DomainBaseImpl{

    // Annotation to stop recursion - known issue
    @JsonIgnore
    @ManyToOne
    private OrderHeader orderHeader ;

    @OneToOne
    private Product product;

    private Integer quantity;

}
