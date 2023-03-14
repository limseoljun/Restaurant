package com.example.restaurant.domain.owner.domain;

import com.example.restaurant.exception.OwnerNameNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository <Owner,Long>{

    boolean existsByName(String name);
    boolean existsByPassword(String password);

    boolean existsByNameAndPassword(String name, String password);

    Optional<Owner> findByName(String owner);

    default Owner validateName(String name) {
        Optional<Owner> optionalOwner = findByName(name);
        return optionalOwner.orElseThrow(() ->
                new OwnerNameNotFoundException("Invalid Owner Name")
        );
    }
}
