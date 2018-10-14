package com.salesorderprocessing.service;

import com.salesorderprocessing.domain.Product;
import com.salesorderprocessing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        Optional<Product> Product = productRepository.findById(id);
        if (Product.isPresent()) {
            return Product.get();
        }
        return null;
    }

    @Override
    public Product saveOrUpdate(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) productRepository.deleteById(id);
    }

}
