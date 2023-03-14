package com.example.restaurant.domain.user.domain;

import com.example.restaurant.exception.UserIdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByName(String name);

    boolean existsByPassword(String password);

    Optional<User> findByName(String name);

    default User validateName(String name){
            Optional<User> optionalUser = findByName(name);
            return optionalUser.orElseThrow(() ->
                    new UsernameNotFoundException("Invalid User Name")
            );

    }

    default User validateUser(Long id){
        Optional<User> optionalUser = findById(id);
        return optionalUser.orElseThrow(() ->
                new UserIdNotFoundException()
        );
    };
}
