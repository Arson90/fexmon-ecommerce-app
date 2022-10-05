package com.fexmon.fexmonecommerce.service.impl;

import com.fexmon.fexmonecommerce.exception.CartNotFoundException;
import com.fexmon.fexmonecommerce.model.CartModel;
import com.fexmon.fexmonecommerce.model.ProductModel;
import com.fexmon.fexmonecommerce.repository.CartRepository;
import com.fexmon.fexmonecommerce.repository.ProductRepository;
import com.fexmon.fexmonecommerce.service.CartService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<CartModel> fetchAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public CartModel fetchCart(final Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> CartNotFoundException.createForCartId(cartId));
    }

    @Override
    public CartModel saveCart() {
        return cartRepository.save(new CartModel(new HashSet<>(), 0.0, 1));
    }

    @Override
    public CartModel updateCart(final Long productId) {
        Optional<CartModel> optionalCart = cartRepository.findAll().stream().findAny();

        if (optionalCart.isEmpty()) {
            saveCart();
        }

        final CartModel cart = cartRepository.findAll().stream().findFirst().get();
        final ProductModel product = productRepository.findById(productId).get();
        cart.getProductModelSet().add(product);
        double sum = calculateTotalProductPrice(cart.getProductModelSet());
        cart.setTotalPrice(sum);
        cart.setQuantity(1);

        return cartRepository.save(cart);
    }

    private double calculateTotalProductPrice(Set<ProductModel> set) {
        return set.stream().mapToDouble(ProductModel::getPrice).sum();
    }

    @Override
    public void deleteCart(final Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public Optional<CartModel> addProductToCart(final Long cartID, final Long productId) {
        return cartRepository.findById(cartID)
                .map(cartModel -> {
                    productRepository.findById(productId)
                            .map(productModel -> cartModel
                                    .getProductModelSet()
                                    .add(productModel));
                    return cartRepository.save(cartModel);
        });
    }
}
