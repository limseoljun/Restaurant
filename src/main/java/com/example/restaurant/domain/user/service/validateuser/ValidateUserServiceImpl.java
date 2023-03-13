package com.example.restaurant.domain.user.service.validateuser;

import com.example.restaurant.controller.dto.user.UserDto;
import com.example.restaurant.domain.user.domain.UserRepository;
import com.example.restaurant.exception.UserNameDuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ValidateUserServiceImpl implements ValidateUserService{
    private final UserRepository userRepository;

    @Override
    public void validteUser(UserDto dto) {
        if (userRepository.existsByName(dto.getName())){
            throw new UserNameDuplicateException();
        }
    }
}
