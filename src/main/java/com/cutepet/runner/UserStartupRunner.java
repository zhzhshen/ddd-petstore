package com.cutepet.runner;

import com.cutepet.domain.User.Cart;
import com.cutepet.domain.User.PetInCart;
import com.cutepet.domain.User.User;
import com.cutepet.repositories.User.CartRepository;
import com.cutepet.repositories.User.PetInCartRepository;
import com.cutepet.repositories.User.UserRepository;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class UserStartupRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    PetInCartRepository petRepository;

    @Override
    public void run(String...args) throws Exception {

        // Create some users
        userRepository.save(ImmutableList.of(
                new User("Jack", "123456789", "Somewhere"),
                new User("Chloe", "123456789", "Somewhere"),
                new User("Kim", "123456789", "Somewhere")
        ));

        // Each user have a cart
        cartRepository.save(ImmutableList.of(
                new Cart(userRepository.findByName("Jack").get(0).getId()),
                new Cart(userRepository.findByName("Chloe").get(0).getId()),
                new Cart(userRepository.findByName("Kim").get(0).getId())
        ));

        // Put some pets in cart
        Cart cart;
        cart = cartRepository.findByUserId(userRepository.findByName("Jack").get(0).getId()).get(0);
        petRepository.save(ImmutableList.of(
            new PetInCart(1L, 1L, cart.getId()),
            new PetInCart(2L, 1L, cart.getId())
        ));

        cart = cartRepository.findByUserId(userRepository.findByName("Chloe").get(0).getId()).get(0);
        petRepository.save(ImmutableList.of(
                new PetInCart(3L, 1L, cart.getId())
        ));

    }
}
