package com.example.restaurant.controller.owner;

import com.example.restaurant.controller.owner.dto.OwnerLoginControllerDto;
import com.example.restaurant.domain.owner.service.ownerlogin.OwnerLoginService;
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
@SessionAttributes("ownerId")
@RequestMapping(value = "/owner/login")
public class OwnerLoginController {
    private final OwnerLoginService ownerLoginService;

    @GetMapping("")
    public String get(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "thymeleaf/owner/login";
    }

    @PostMapping("")
    public String post(@Valid OwnerLoginControllerDto dto, Model model) {
        model.addAttribute("ownerId", ownerLoginService.login(dto.convertDto()));
        return "redirect:/owner/my-page";
    }
}
