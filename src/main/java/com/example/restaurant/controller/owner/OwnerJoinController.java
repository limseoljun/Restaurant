package com.example.restaurant.controller.owner;

import com.example.restaurant.controller.owner.dto.OwnerJoinControllerDto;
import com.example.restaurant.domain.owner.service.ownerjoin.OwnerJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/owner/join")
public class OwnerJoinController {
    private final OwnerJoinService ownerJoinService;

    @GetMapping("")
    public String get() {
        return "thymeleaf/owner/join";
    }

    @PostMapping("")
    public String post(@Valid OwnerJoinControllerDto dto) {
        ownerJoinService.join(dto.convertDto());
        return "thymeleaf/owner/login";
    }
}
