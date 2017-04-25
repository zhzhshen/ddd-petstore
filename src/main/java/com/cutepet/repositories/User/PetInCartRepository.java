package com.cutepet.repositories.User;

import com.cutepet.domain.User.PetInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetInCartRepository extends JpaRepository<PetInCart, Long> {

}
