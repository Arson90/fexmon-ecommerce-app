package com.fexmon.fexmonecommerce.controller;

import com.fexmon.fexmonecommerce.model.ProductModel;
import com.fexmon.fexmonecommerce.model.UserModel;
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
    public ResponseEntity<ProductModel> getProductById(@PathVariable final long productId) {
        final ProductModel product = productService.fetchProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        final List<ProductModel> productModels = productService.fetchProductList();
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductModel> addProduct(@RequestBody final ProductModel product) {
        final ProductModel productModel = productService.saveProduct(product);
        return new ResponseEntity<>(productModel, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody final ProductModel product, @PathVariable final long id) {
        final ProductModel productModel = productService.updateProduct(product, id);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable final long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
