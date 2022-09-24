package com.fexmon.fexmonecommerce.controller;

import com.fexmon.fexmonecommerce.model.ProductModel;
//import com.fexmon.fexmonecommerce.model.UserModel;
import com.fexmon.fexmonecommerce.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/fexmon")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductModel getProductById(@PathVariable final long productId) {
        return productService.fetchProduct(productId);
    }

    @GetMapping("/product/name/{productName}")
    public ProductModel getProductByProductName(@PathVariable final String productName) {
        return productService.fetchProductByProductName(productName);
    }

    @GetMapping("/product")
    public List<ProductModel> getAllProducts() {
        return productService.fetchProductList();
    }

    @PostMapping("/product")
    public ProductModel addProduct(@RequestBody final ProductModel product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public ProductModel updateProduct(@RequestBody final ProductModel product, @PathVariable final long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final long id) {
        productService.deleteProduct(id);
    }
}
