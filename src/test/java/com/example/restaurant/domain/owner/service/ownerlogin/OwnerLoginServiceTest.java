package com.example.restaurant.domain.owner.service.ownerlogin;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.exception.OwnerNameNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OwnerLoginServiceTest {
    private final OwnerLoginService ownerLoginService;
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder bCryptEncoder;
    @Autowired
    OwnerLoginServiceTest(OwnerLoginService ownerLoginService, OwnerRepository ownerRepository, PasswordEncoder bCryptEncoder) {
        this.ownerLoginService = ownerLoginService;
        this.ownerRepository = ownerRepository;
        this.bCryptEncoder = bCryptEncoder;
    }

    @Test
    void 사업자_로그인_정상작동(){
        Owner owner = new Owner("owner",bCryptEncoder.encode("1234"));
        ownerRepository.save(owner);
        OwnerDto dto = new OwnerDto("owner","1234");

        Long loginId = ownerLoginService.login(dto);

        assertEquals(owner.getId(),loginId);
    }
    @Test
    void 사업자_아이디_다름(){
        Owner owner = new Owner("owner",bCryptEncoder.encode("1234"));
        ownerRepository.save(owner);
        OwnerDto dto = new OwnerDto("owner1","1234");

        Exception e = assertThrows(OwnerNameNotFoundException.class, ()->
                 ownerLoginService.login(dto)
        );

        assertEquals(e.getMessage(),"Invalid Owner Name");
    }

    @Test
    void 사업자_비밀번호_다름(){
        Owner owner = new Owner("owner",bCryptEncoder.encode("1234"));
        ownerRepository.save(owner);
        OwnerDto dto = new OwnerDto("owner","12345");

        Exception e = assertThrows(BadCredentialsException.class, ()->
                ownerLoginService.login(dto)
        );

        assertEquals(e.getMessage(),"Invalid Owner Password");
    }
}