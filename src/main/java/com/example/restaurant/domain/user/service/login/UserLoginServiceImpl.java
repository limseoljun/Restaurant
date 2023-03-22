package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.domain.servicedto.user.UserDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService{
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptEncoder;

    @Override
    public Long validate(UserDto dto) {
        User user = userRepository.validateName(dto.getName());
        if(!user.isValidPassword(bCryptEncoder, dto.getPassword())){
            throw new BadCredentialsException("Invalid User Password");
        }
        return user.getId();
    }
}
