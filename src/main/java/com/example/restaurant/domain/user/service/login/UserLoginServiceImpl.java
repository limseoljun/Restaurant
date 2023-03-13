package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.controller.dto.user.UserDto;
import com.example.restaurant.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService{
    private final UserRepository userRepository;

    @Override
    public void validateLogin(UserDto dto) {
        if(!userRepository.existsByName(dto.getName())) {
            throw new BadCredentialsException("Validate User Name");
        }else if(!userRepository.existsByPassword(dto.getPassword())){
            throw new BadCredentialsException("Validate User Password");
        }
    }
}
