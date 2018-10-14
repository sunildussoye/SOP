package com.salesorderprocessing.domain;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Order status at different stages")

public enum OrderStatus {
    NEW,
    ALLOCATED,
    SHIPPED,
    PARTDELIVERED,
    DELIVERED
}
