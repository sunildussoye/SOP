package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.domain.ReportParameters;
import com.salesorderprocessing.repository.CustomerRepository;
import com.salesorderprocessing.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderRepository orderRepository;

    // will use for other reports related to customers
    @Autowired
    private CustomerRepository customerRepository;


    // using native query in repository
    @Override
    public List<OrderHeader> orderList(ReportParameters reportParameters) {

        if (reportParameters != null)
            try {
                return orderRepository.orderList(reportParameters.getOrderNum());
            } catch (NullPointerException e) {
                e.getMessage();
            }
        return null;
    }

    /** no dto .. look at object mapper
    // To do
    @Override
    public List<CustomerOrder> outstandingOrder(ReportParameters reportParameters) {
        if (reportParameters != null)
            try {
                return customerRepository.outstandingOrder(reportParameters.getCustomer().getCustReference());
            } catch (NullPointerException e) {
                e.getMessage();
            }
        return null;
    }

    //To do
    @Override
    public DeliveryNoteMatching deliverynotematching(ReportParameters reportParameters) {
        return null;
    }
    **/
}
