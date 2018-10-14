package com.salesorderprocessing.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel(description = "Report parameters Object - used to pass parameters to report")
public class ReportParameters {

    private String orderNum ;
    private String  name;
    private Date orderDate;
    private Customer customer;

}
