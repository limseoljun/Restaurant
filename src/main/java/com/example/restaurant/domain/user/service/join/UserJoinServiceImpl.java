package com.example.restaurant.domain.user.service.join;

import com.example.restaurant.controller.dto.user.UserDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserJoinServiceImpl implements UserJoinService{
    private UserRepository userRepository;

    @Override
    public void validateJoin(UserDto dto){
        User user = new User(dto.getName(),dto.getPassword(), dto.getNickName(),dto.getPhoneNum(), dto.getHomeAddress());
        userRepository.save(user);
    }
}
