package com.salesorderprocessing.controller;

import com.salesorderprocessing.domain.OrderHeader;
import com.salesorderprocessing.domain.ReportParameters;
import com.salesorderprocessing.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/report")
@RestController
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("{id}")
    public List<OrderHeader> getOrderList(@PathVariable(value = "id") String Id) {

        // to expand with more parameters or generic parameters
        // use the ones that are required , here it is orderNum
        final ReportParameters reportParameters = ReportParameters.builder()
                .orderNum(Id)
                .build();

        return this.reportService.orderList(reportParameters);
    }






}
