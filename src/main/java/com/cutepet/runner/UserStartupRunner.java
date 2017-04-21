package com.cutepet.runner;

import com.cutepet.domain.User.Cart;
import com.cutepet.domain.User.Pet;
import com.cutepet.domain.User.User;
import com.cutepet.repositories.User.CartRepository;
import com.cutepet.repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class UserStartupRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public void run(String...args) throws Exception {

        // Create some users
        userRepository.save(new User("Jack", "123456789", "Somewhere"));
        userRepository.save(new User("Chloe", "123456789", "Somewhere"));
        userRepository.save(new User("Kim", "123456789", "Somewhere"));

        // Each user have a cart, and put some pets in cart
        long userId;
        Cart cart;

        userId = userRepository.findByName("Jack").get(0).getId();
        cartRepository.save(new Cart(userId));
        cart = cartRepository.findByUserId(userId).get(0);
        cart.addPet(new Pet(1L, 1L));
        cart.addPet(new Pet(2L, 1L));

        userId = userRepository.findByName("Chloe").get(0).getId();
        cartRepository.save(new Cart(userId));
        cart.addPet(new Pet(3L, 1L));

        userId = userRepository.findByName("Kim").get(0).getId();
        cartRepository.save(new Cart(userId));

    }
}
