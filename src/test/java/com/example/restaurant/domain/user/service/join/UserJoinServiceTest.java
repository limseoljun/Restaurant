package com.example.restaurant.domain.user.service.join;

import com.example.restaurant.domain.servicedto.user.UserDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserJoinServiceTest {
    private final UserRepository userRepository;
    private final UserJoinService userJoinService;
    private final PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserJoinServiceTest(UserRepository userRepository, UserJoinService userJoinService, PasswordEncoder bCyptPasswordEncoder, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userJoinService = userJoinService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Test
    void 유저_회원가입_정상작동(){
        UserDto dto = new UserDto("user","1234","nick","phone","home");

        userJoinService.join(dto);
        User user = userRepository.findByName(dto.getName()).get();

        assertEquals(user.getName(),dto.getName());
        assertNotEquals(user.getPassword(),dto.getPassword());
        assertEquals(user.getNickName(),dto.getNickName());
        assertEquals(user.getPhoneNum(),dto.getPhoneNum());
        assertEquals(user.getHomeAddress(),dto.getHomeAddress());
    }
}