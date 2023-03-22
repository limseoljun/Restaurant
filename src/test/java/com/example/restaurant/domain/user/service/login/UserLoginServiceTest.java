package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.domain.servicedto.user.UserDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserLoginServiceTest {
    private final UserRepository userRepository;
    private final UserLoginService userLoginService;
    private final PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserLoginServiceTest(UserRepository userRepository, UserLoginService userLoginService, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userLoginService = userLoginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Test
    void 유저_로그인_정상작동(){
        User user = new User("user",bCryptPasswordEncoder.encode("1234"),"nick","phone","123");
        userRepository.save(user);
        UserDto dto = new UserDto("user","1234");

        Long loginId = userLoginService.validate(dto);

        assertEquals(user.getId(),loginId);
    }

    @Test
    void 유저_아이디_다름(){
        User user = new User("user",bCryptPasswordEncoder.encode("1234"),"nick","phone","123");
        userRepository.save(user);
        UserDto dto = new UserDto("user1","1234");

        Exception e = assertThrows(UsernameNotFoundException.class, () ->
                userLoginService.validate(dto)
        );

        assertEquals(e.getMessage(),"Invalid User Name");
    }

    @Test
    void 유저_비밀번호_다름(){
        User user = new User("user",bCryptPasswordEncoder.encode("1234"),"nick","phone","123");
        userRepository.save(user);
        UserDto dto = new UserDto("user","12345");

        Exception e = assertThrows(BadCredentialsException.class, () ->
                userLoginService.validate(dto)
        );

        assertEquals(e.getMessage(),"Invalid User Password");
    }

    @Test
    void 유저_아이디_비밀번호_다름(){
        User user = new User("user",bCryptPasswordEncoder.encode("1234"),"nick","phone","123");
        userRepository.save(user);
        UserDto dto = new UserDto("user1",bCryptPasswordEncoder.encode("12345"));

        Exception e = assertThrows(UsernameNotFoundException.class, () ->
                userLoginService.validate(dto)
        );

        assertEquals(e.getMessage(),"Invalid User Name");
    }
}