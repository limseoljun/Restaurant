package com.example.restaurant.controller.food;

import com.example.restaurant.controller.owner.dto.ValidateOwnerControllerDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/food/validate-update")
public class FoodValidateUpdateController {
    private final ValidateOwnerService validateOwnerService;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    /**
     * foodId 를 view 페이지에서 받아옴
     * updateFoodId 에 담아서 view 페이지로 보냄
     */
    @GetMapping("")
    public String get(@RequestParam("foodId") Long foodId, Model model) {
        model.addAttribute("updateFoodId", foodId);
        return "thymeleaf/owner/validate-owner";
    }

    /**
     * foodId,ValidateOwnerControllerDto 를 받아옴
     * validateOwnerService 로 검증하고
     * foodRepository 와 restaurantRepository 를 이용해서 객체를 찾음
     * restaurant 객체의 고유번호와 food 객체 안의 restaurant 고유번호가 일치하면 view 페이지 이동
     */
    @PostMapping("")
    public String post(@RequestParam("foodId") Long foodId, ValidateOwnerControllerDto ownerDto) {
        Restaurant restaurant = null;
        Long ownerId = validateOwnerService.validate(ownerDto.convertDto());
        Optional<Food> optionalFood = foodRepository.findById(foodId);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByOwnerId(ownerId);

        if (optionalRestaurant.get().getId() == optionalFood.get().getRestaurantId()) {
            return "redirect:/food/update?foodId=" + foodId;
        }
        return "redirect:/owner/my-restaurant";
    }
}
