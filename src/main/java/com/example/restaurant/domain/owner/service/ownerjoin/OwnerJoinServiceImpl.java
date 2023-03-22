package com.example.restaurant.domain.owner.service.ownerjoin;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.exception.OwnerNameDuplicateException;
import com.example.restaurant.exception.PasswordEncodingFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerJoinServiceImpl implements OwnerJoinService {
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder bCryptEncoder;

    @Override
    public void join(OwnerDto dto){
        Owner owner = new Owner(dto.getName(),
                dto.getPassword()
        );
        duplicatedOwnerName(dto);
        checkEncodingPw(owner,dto.getPassword());
        ownerRepository.save(owner);
    }

    private void duplicatedOwnerName(OwnerDto dto){
        if(ownerRepository.existsByName(dto.getName())){
            throw new OwnerNameDuplicateException();
        }
    }
    private void checkEncodingPw(Owner owner, String password) {
        if(!owner.isEncodePassword(bCryptEncoder, password)) {
            throw new PasswordEncodingFailedException();
        }
    }
}
