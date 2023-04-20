package com.example.restaurant.domain.owner.service.validateowner;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ValidateOwnerServiceImpl implements ValidateOwnerService {
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder bCryptEncoder;

    @Override
    public Long validate(OwnerDto dto) {
        Owner owner = ownerRepository.validateName(dto.getName());
        if (!owner.isValidPassword(bCryptEncoder, dto.getPassword())) {
            throw new BadCredentialsException("Invalid Owner Password");
        }
        return owner.getId();
    }
}
