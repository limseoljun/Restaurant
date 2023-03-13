package com.example.restaurant.domain.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByName(String name);

    boolean existsByPassword(String password);
}
