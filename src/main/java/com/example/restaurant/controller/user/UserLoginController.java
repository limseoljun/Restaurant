package com.example.restaurant.controller.user;

import com.example.restaurant.controller.user.dto.UserLoginControllerDto;
import com.example.restaurant.domain.user.service.login.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@SessionAttributes("userId")
@RequestMapping(value = "/user/login")
public class UserLoginController {
    private final UserLoginService userLoginService;

    @GetMapping("")
    public String get(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "thymeleaf/user/login";
    }

    @PostMapping("")
    public String post(@Valid UserLoginControllerDto dto, Model model) {
        model.addAttribute("userId", userLoginService.validate(dto.convertDto()));
        return "redirect:/restaurants/main";
    }
}
