package com.example.restaurant.domain.user.service.join;

import com.example.restaurant.controller.dto.user.UserDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import com.example.restaurant.exception.PasswordEncodingFailedException;
import com.example.restaurant.exception.UserNameDuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserJoinServiceImpl implements UserJoinService{
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptEncoder;

    @Override
    public void join(UserDto dto){
        User user = new User(dto.getName(),dto.getPassword(), dto.getNickName(),dto.getPhoneNum(), dto.getHomeAddress());
        duplicatedUserName(dto);
        checkEncodingPw(user, dto.getPassword());
        userRepository.save(user);
    }

    private void duplicatedUserName(UserDto dto) {
        if (userRepository.existsByName(dto.getName())){
            throw new UserNameDuplicateException();
        }
    }

    private void checkEncodingPw(User user, String password) {
        if(!user.isEncodePassword(bCryptEncoder, password)) {
            throw new PasswordEncodingFailedException();
        }
    }
}
