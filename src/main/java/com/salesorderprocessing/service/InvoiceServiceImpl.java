package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Invoice;
import com.salesorderprocessing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository ;

    @Override
    public Iterable<Invoice> listAll() {
        return null;
    }

    @Override
    public Invoice getById(Integer id) {
        return null;
    }

    @Override
    public Invoice saveOrUpdate(Invoice entity) {
        return invoiceRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {

    }
}
