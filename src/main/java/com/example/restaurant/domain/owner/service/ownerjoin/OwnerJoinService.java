package com.example.restaurant.domain.owner.service.ownerjoin;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.exception.OwnerNameDuplicateException;
import com.example.restaurant.exception.PasswordEncodingFailedException;

public interface OwnerJoinService {
    /**
     * dto를 받아서 중복된 id인지 체크하 비밀번호는 encoding 해서 저장
     * @param dto 가게주인의 이름(id),비밀번호
     * @throws OwnerNameDuplicateException 중복된 아이디 일때
     * @throws PasswordEncodingFailedException 비밀번호 encoding 에 실패했을때
     */
    void join(OwnerDto dto);
}
