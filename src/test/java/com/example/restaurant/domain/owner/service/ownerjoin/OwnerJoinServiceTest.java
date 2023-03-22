package com.example.restaurant.domain.owner.service.ownerjoin;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.exception.OwnerNameDuplicateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OwnerJoinServiceTest {
    private final OwnerRepository ownerRepository;
    private final OwnerJoinService ownerJoinService;

    @Autowired
    OwnerJoinServiceTest(OwnerRepository ownerRepository, OwnerJoinService ownerJoinService) {
        this.ownerRepository = ownerRepository;
        this.ownerJoinService = ownerJoinService;
    }

    @Test
    void 사업자_가입_정상작동(){
        OwnerDto dto = new OwnerDto("owner","1234");
        ownerJoinService.join(dto);

        Owner owner = ownerRepository.findByName("owner").get();

        assertEquals(dto.getName(),owner.getName());
        assertNotEquals(dto.getPassword(),owner.getPassword());
    }

    @Test
    void 사업자_아이디_중복(){
        Owner owner = new Owner("owner","1234");
        ownerRepository.save(owner);
        OwnerDto dto = new OwnerDto("owner","2345");

        Exception e = assertThrows(OwnerNameDuplicateException.class, () ->
                ownerJoinService.join(dto)
        );

        assertEquals("Duplicate Owner Name",e.getMessage());
    }
}