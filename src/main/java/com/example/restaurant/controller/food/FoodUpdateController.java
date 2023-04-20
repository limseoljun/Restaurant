package com.example.restaurant.controller.food;

import com.example.restaurant.controller.food.dto.FoodAddControllerDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.food.service.foodchange.FoodChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/food/update")
public class FoodUpdateController {
    private final FoodChangeService foodChangeService;
    private final FoodRepository foodRepository;

    /**
     * view 에서 foodId 를 받아옴
     * foodId 를 이용해 foodRepository 에 객체가 있으면 객체를 "food" 에 넣음
     * view 페이지로 보냄
     */
    @GetMapping("")
    public String get(@RequestParam("foodId")Long foodId, Model model){
        foodRepository.findById(foodId).ifPresent(food -> {
            model.addAttribute("food",food);
        });
        return "thymeleaf/food/update";
    }

    /**
     * view 에서 foodId,FoodAddControllerDto,file 을 받아옴
     * foodChangeService 실행 후 view 페이지로 보냄
     */
    @PostMapping("")
    public String post(@RequestParam("foodId")Long foodId, FoodAddControllerDto dto, MultipartFile file){
        if(foodChangeService.change(foodId,dto.convertDto(),file)){
            return "redirect:/owner/my-restaurant";
        }
        return "redirect:/owner/my-restaurant";
    }
}
