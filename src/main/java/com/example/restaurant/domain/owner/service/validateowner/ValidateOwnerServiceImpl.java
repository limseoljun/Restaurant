package com.example.restaurant.domain.owner.service.validateowner;

import com.example.restaurant.controller.dto.owner.OwnerDto;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.exception.OwnerNameAndPasswordDifferentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ValidateOwnerServiceImpl implements ValidateOwnerService {
    private final OwnerRepository ownerRepository;
    @Override
    public void validte(OwnerDto dto) {
        if (!ownerRepository.existsByNameAndPassword(dto.getName(),dto.getPassword())){
            throw new OwnerNameAndPasswordDifferentException();
        }
    }
}
