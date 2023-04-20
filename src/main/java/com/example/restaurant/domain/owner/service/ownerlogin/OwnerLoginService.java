package com.example.restaurant.domain.owner.service.ownerlogin;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import org.springframework.security.authentication.BadCredentialsException;

public interface OwnerLoginService {
    /**
     * dto 로 주인의 아이디 비번을 받고 DB에 아이디 있는지 검증 가져와서 encoding 된 비번을 입력한 비번과 비교
     * @param dto
     * @return 가져온 주인의 고유번호를 반환
     * @throws BadCredentialsException 비밀번호 다를시 발생
     */
    Long login(OwnerDto dto);

}
