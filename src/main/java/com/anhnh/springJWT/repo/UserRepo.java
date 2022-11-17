package com.anhnh.springJWT.repo;

import com.anhnh.springJWT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
