package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.domain.image.service.ImageUploadService;
import com.example.restaurant.domain.servicedto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodChangeServiceImpl implements FoodChangeService {
    private final FoodRepository foodRepository;
    private final ImageUploadService imageUploadService;

    @Override
    public boolean change(Long foodId, FoodDto dto, MultipartFile file) {
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.update(
                    dto.getName(),
                    dto.getPrice(),
                    dto.getInfo(),
                    dto.getCategory()
            );
            imageUploadService.upload(foodOptional.get().getName(), file, foodOptional.get());
            return true;
        }
        return false;
    }
}
