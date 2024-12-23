package com.example.Sale.Campaign.Management.System.services;

import com.example.Sale.Campaign.Management.System.model.Product;
import com.example.Sale.Campaign.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(List<Product> products) {
        productRepository.saveAll(products);
    }

    public Page<Product> applyPagination(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return productRepository.findAll(pageable);
}
}
