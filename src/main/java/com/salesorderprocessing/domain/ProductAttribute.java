package com.salesorderprocessing.domain;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@ApiModel(description = "Product attributes that are not applicable to all products")

public class ProductAttribute {

    private double size;
    private String colour;
    private String sex;
    private String stripes;
}
