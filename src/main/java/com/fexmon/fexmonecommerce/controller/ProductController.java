package com.fexmon.fexmonecommerce.controller;

import com.fexmon.fexmonecommerce.model.ProductModel;
import com.fexmon.fexmonecommerce.model.UserModel;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductController {

    @GetMapping("/product/{id}")
    public ProductModel getProductById(@PathVariable final long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/product")
    public List<ProductModel> getAllProducts() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody final ProductModel product) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@RequestBody final ProductModel product, @PathVariable final long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
