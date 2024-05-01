package com.flakozzz.eCommerce.modules.user;

import java.util.Optional;

import com.flakozzz.eCommerce.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
