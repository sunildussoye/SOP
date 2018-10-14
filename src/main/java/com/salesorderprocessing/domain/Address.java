package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
@ApiModel(description = "Different Adresss for the customers - Customer Address,Delivery,Invoice & Return")

public class Address  {
    @ApiModelProperty(notes = "Address cannot be blank")
    private String addressLine1;
    @NotBlank(message = "Address Line 2 is required")
    private String addressLine2;
    private String addressLine3;
    @NotBlank
    private String postCode;
    @NotBlank
    private String country;
}
