package com.example.restaurant.controller.user;

import com.example.restaurant.controller.user.dto.UserJoinControllerDto;
import com.example.restaurant.domain.user.service.join.UserJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user/join")
public class UserJoinController {
    private final UserJoinService userJoinService;

    @GetMapping("")
    public String get() {
        return "thymeleaf/user/join";
    }
    @PostMapping("")
    public String post(@Valid UserJoinControllerDto dto) {
        userJoinService.join(dto.convertDto());

        return "thymeleaf/user/login";
    }
}
