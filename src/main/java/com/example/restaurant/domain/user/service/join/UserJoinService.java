package com.example.restaurant.domain.user.service.join;

import com.example.restaurant.domain.servicedto.user.UserDto;
import com.example.restaurant.exception.PasswordEncodingFailedException;
import com.example.restaurant.exception.UserNameDuplicateException;

public interface UserJoinService {
    /**
     * dto 를 받아와서 중복된 아이디가 있는지 확인 후 비밀번호 encoding 후 저장
     * @param dto (name(아이디),password,nickname,phoneNum,Address)
     * @throws UserNameDuplicateException 중복된 name(아이디)일 경우
     * @throws PasswordEncodingFailedException encoding 실패 했을 경우
     */
    void join(UserDto dto);
}
