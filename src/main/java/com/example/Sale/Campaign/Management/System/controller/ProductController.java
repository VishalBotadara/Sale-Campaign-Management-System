package com.example.Sale.Campaign.Management.System.controller;

import com.example.Sale.Campaign.Management.System.model.Product;
import com.example.Sale.Campaign.Management.System.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping("saveProduct")
    public void saveProduct(@RequestBody List<Product> products){
        productServices.saveProduct(products);
    }
    @GetMapping("/pagination")
    public Page<Product> pagination(@RequestParam int page,@RequestParam int pageSize) {
        return productServices.applyPagination(page,pageSize);
    }
}
