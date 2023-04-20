package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.domain.servicedto.user.UserDto;
import org.springframework.security.authentication.BadCredentialsException;

public interface UserLoginService {
    /**
     * dto 로 유저의 아이디 비번을 받고 DB에 아이디 있는지 검증 가져와서 encoding 된 비번을 입력한 비번과 비교
     * @param dto
     * @return 가져온 유저의 고유번호를 반환
     * @throws BadCredentialsException 비밀번호 다를시 발생
     */
    Long validate(UserDto dto);
}

