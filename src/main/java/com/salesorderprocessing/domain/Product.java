package com.salesorderprocessing.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@ApiModel(description = "All products on sale")

public class Product extends DomainBaseImpl{
    @ApiModelProperty(name = "Running / Football / Tennis ")
    private String productCategory;

    private String productDescription;
    @NonNull
    private BigDecimal productPrice;

    private Boolean productAvailable;

    @Embedded
    private ProductAttribute productAttribute;
}
