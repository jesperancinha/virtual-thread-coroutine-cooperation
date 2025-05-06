package org.jesperancinha.vtcc.service;

import org.jesperancinha.vtcc.domain.Product;
import org.jesperancinha.vtcc.domain.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Iterable<Product> getAllItems() {
        return productDao.findAll();
    }

    public Optional<Product> getItemById(UUID uUID) {
        return productDao.findById(uUID);
    }
}