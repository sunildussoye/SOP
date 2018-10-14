package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Return;
import com.salesorderprocessing.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    @Override
    public Iterable<Return> listAll() {
        return null;
    }

    @Override
    public Return getById(Integer id) {
        return null;
    }

    @Override
    public Return saveOrUpdate(Return entity) {
        return returnRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {

    }
}
