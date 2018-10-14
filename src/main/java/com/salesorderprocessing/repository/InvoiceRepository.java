package com.salesorderprocessing.repository;

import com.salesorderprocessing.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

}
