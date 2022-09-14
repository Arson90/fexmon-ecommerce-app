package com.fexmon.fexmonecommerce.service.impl;

import com.fexmon.fexmonecommerce.model.ProductModel;
import com.fexmon.fexmonecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {

    private List<ProductModel> productModelList;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp() {
        final ProductModel product1 = new ProductModel(1L,"Milk", 3.20);
        final ProductModel product2 = new ProductModel(2L, "Orange", 5.50);
        final ProductModel product3 = new ProductModel(3L, "Water", 2.35);
        productModelList = Arrays.asList(product1, product2, product3);
    }

    @Test
    void shouldBeCheckedIfSpecificProductNameExists() {
        //given
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(productModelList.get(0)));

        //when
        final ProductModel productModel = productServiceImpl.fetchProduct(1L);

        //then
        assertEquals("Milk", productModel.getProductName(), "Should be Milk");
    }

    @Test
    void shouldBeReturnedSpecificProductListSize() {
        //given
        Mockito.when(productRepository.findAll()).thenReturn(productModelList);

        //when
        final List<ProductModel> fetchedProductList = productServiceImpl.fetchProductList();

        //then
        assertEquals(3, fetchedProductList.size(), "Should be 3 elements");
    }

    @Test
    void verifyIfProductRepositorySaveMethodWillRun() {
        //given
        final ProductModel product = new ProductModel(4L, "Apple", 3.35);

        //when
        productServiceImpl.saveProduct(product);

        //then
        Mockito.verify(productRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void updateProduct() {
        //given
        final ProductModel product = new ProductModel(2L, "Apple", 3.35);
        final Long productId = product.getId();

        //when
        productServiceImpl.updateProduct(product, productId);

        //then
        Mockito.verify(productRepository, Mockito.times(1)).save(Mockito.any(ProductModel.class));
    }

    @Test
    void verifyIfProductRepositoryDeleteByIdMethodWillRun() {
        //when
        productServiceImpl.deleteProduct(1L);

        //then
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);
    }
}