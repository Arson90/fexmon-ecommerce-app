package com.fexmon.fexmonecommerce.service.impl;

import com.fexmon.fexmonecommerce.exception.ProductNotFoundException;
import com.fexmon.fexmonecommerce.model.ProductModel;
import com.fexmon.fexmonecommerce.repository.ProductRepository;
import com.fexmon.fexmonecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel fetchProduct(final Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> ProductNotFoundException.createForProductId(productId));
    }

    @Override
    public List<ProductModel> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel saveProduct(final ProductModel product) {
        return productRepository.save(product);
    }

    @Override
    public ProductModel updateProduct(final ProductModel product, final Long productId) {
        return replaceProduct(product, productId);
    }

    private ProductModel replaceProduct(final ProductModel product, final Long productId) {
        return productRepository.findById(productId)
                .map(productModel -> {
                    productModel.setProductName(product.getProductName());
                    productModel.setPrice(product.getPrice());
                    return productRepository.save(productModel);
                }).orElseGet(() -> {
                    product.setId(productId);
                    return productRepository.save(product);
                });
    }

    @Override
    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }
}
