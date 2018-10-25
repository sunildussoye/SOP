package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Data
@EqualsAndHashCode(callSuper = false)

@ApiModel(description = "Customers we are dealing with, excluding vendors, or personnel")

public class Customer extends DomainBaseImpl {

    @NotBlank(message = "Customer Reference must be entered")
    private String custReference;

    @Size(min = 2, max = 50)
    @ApiModelProperty(notes = "first name must be greater than 2 and less tha 50 characters long")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @NotBlank(message = "Enter a valid email")
    private String email;
    private String phoneNumber;

    // allowable addressType , (C)ustomer ,(D)elivery,(I)nvoice ,(R)eturn
    // implementation of  a field validator
    // consult javax/validation/constraint doc for basic validation type

    @AddressTypeConstraint
    @NotBlank
    private String addressType;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1",column = @Column(name="Customeraddressline1")),
        @AttributeOverride(name = "addressLine2",column = @Column(name="Customeraddressline2")),
        @AttributeOverride(name = "addressLine3",column = @Column(name="Customeraddressline3")),
        @AttributeOverride(name = "postCode",    column = @Column(name="Customerpostcode")),
        @AttributeOverride(name = "country",     column = @Column(name="Customercountry"))
    })
    Address customerAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1",column = @Column(name="Deliveryaddressline1")),
            @AttributeOverride(name = "addressLine2",column = @Column(name="Deliveryaddressline2")),
            @AttributeOverride(name = "addressLine3",column = @Column(name="Deliveryaddressline3")),
            @AttributeOverride(name = "postCode",    column = @Column(name="Deliverypostcode")),
            @AttributeOverride(name = "country",     column = @Column(name="Deliverycountry"))
    })
    Address deliveryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1",column = @Column(name="Invoiceaddressline1")),
            @AttributeOverride(name = "addressLine2",column = @Column(name="Invoiceaddressline2")),
            @AttributeOverride(name = "addressLine3",column = @Column(name="Invoiceaddressline3")),
            @AttributeOverride(name = "postCode",    column = @Column(name="Invoicepostcode")),
            @AttributeOverride(name = "country",     column = @Column(name="Invoicecountry"))
    })
    Address invoiceAddress;
}
