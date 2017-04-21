package com.cutepet.repositories.User;

import com.cutepet.domain.User.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(long id);
}
