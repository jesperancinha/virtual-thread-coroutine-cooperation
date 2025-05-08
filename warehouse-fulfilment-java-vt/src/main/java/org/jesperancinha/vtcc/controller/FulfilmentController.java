package org.jesperancinha.vtcc.controller;

import org.jesperancinha.vtcc.domain.Product;
import org.jesperancinha.vtcc.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("fulfilment")
public class FulfilmentController {

    private final ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(FulfilmentController.class);

    @Autowired
    public FulfilmentController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getItems() {
        return productService.getAllItems();
    }

    @GetMapping("{id}")
    public Object getItem(@PathVariable UUID id) {
        return productService.getItemById(id);
    }
}