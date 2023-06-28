package com.example.emtaud.service_or_business;

import com.example.emtaud.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> findAllByUsername(String userId);

    ShoppingCart createNewShoppingCart(String userId);

    ShoppingCart addProductToShoppingCart(String userId,
                                          Long productId);

    ShoppingCart removeProductFromShoppingCart(String userId,
                                               Long productId);

    ShoppingCart getActiveShoppingCart(String userId);

    ShoppingCart cancelActiveShoppingCart(String userId);

    ShoppingCart checkoutShoppingCart(String userId);

}
