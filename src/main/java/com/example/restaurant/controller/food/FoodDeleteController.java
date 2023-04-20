package com.example.restaurant.controller.food;

import com.example.restaurant.controller.owner.dto.ValidateOwnerControllerDto;
import com.example.restaurant.domain.food.service.fooddelete.FoodDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/food/delete")
public class FoodDeleteController {
    private final FoodDeleteService foodDeleteService;

    /**
     * foodId 를 view 에서 받아와서 deleteFoodId 에 값을 넣음
     * view 페이지로 보냄
     */
    @GetMapping("")
    public String get(@RequestParam("foodId")Long foodId, Model model){
        model.addAttribute("deleteFoodId",foodId);
        return "thymeleaf/owner/validate-owner";
    }

    /**
     * view 에서 foodId 와 ValidateOwnerControllerDto 받음
     * 정보를 이용해 foodDeleteService 처리
     * view페이지로 보냄
     */
    @PostMapping("")
    public String post(@RequestParam("foodId")Long foodId, ValidateOwnerControllerDto dto){
        if(foodDeleteService.delete(foodId, dto.convertDto())) {
            return "redirect:/owner/my-restaurant";
        }
        return "redirect:/owner/my-restaurant";
    }
}
