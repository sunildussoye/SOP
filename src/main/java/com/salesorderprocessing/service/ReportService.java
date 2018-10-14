package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.domain.ReportParameters;

import java.util.List;

public interface ReportService {

    // reports customer - list

    // order by customer

    // outstanding order for a customer

    // deliveryNotematching for a customer

    List<OrderHeader> orderList(ReportParameters reportParameters);


  //  List<CustomerOrder> outstandingOrder (ReportParameters reportParameters);

  //  DeliveryNoteMatching deliverynotematching (ReportParameters reportParameters);




}
