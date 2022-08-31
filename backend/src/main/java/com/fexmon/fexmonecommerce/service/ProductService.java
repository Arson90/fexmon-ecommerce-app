package com.fexmon.fexmonecommerce.service;

import com.fexmon.fexmonecommerce.model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel fetchProduct(final Long productId);

    List<ProductModel> fetchProductList();

    ProductModel saveProduct(final ProductModel product);

    ProductModel updateProduct(final ProductModel product, final Long productId);

    void deleteProduct(final Long productId);
}
