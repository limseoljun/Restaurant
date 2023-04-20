package com.example.restaurant.domain.restaurant.service.update;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RestaurantUpdateServiceTest {
    private final RestaurantUpdateService restaurantUpdateService;
    private final RestaurantRepository restaurantRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    RestaurantUpdateServiceTest(RestaurantUpdateService restaurantUpdateService, RestaurantRepository restaurantRepository, OwnerRepository ownerRepository) {
        this.restaurantUpdateService = restaurantUpdateService;
        this.restaurantRepository = restaurantRepository;
        this.ownerRepository = ownerRepository;
    }

    @Test
    void 식당_변경_정상작동(){
        byte[] imageBytes = "test-image".getBytes();
        String imageName = "test-image.jpg";
        MockMultipartFile file = new MockMultipartFile("file", imageName, "image/jpeg", imageBytes);

        Owner owner = new Owner("owner","123");
        ownerRepository.save(owner);
        Restaurant restaurant = new Restaurant("restaurant","address","000",owner.getId());
        restaurantRepository.save(restaurant);
        RestaurantDto restaurantDto = new RestaurantDto("restaurant2","Address2","111");

        boolean isUpdate = restaurantUpdateService.update(restaurant.getId(), restaurantDto,file);

        assertTrue(isUpdate);
        assertEquals(restaurantDto.getName(),restaurant.getName());
        assertEquals(restaurantDto.getBusinessAddress(),restaurant.getBusinessAddress());
        assertEquals(restaurantDto.getCallNum(),restaurant.getCallNum());
        assertEquals(owner.getId(),restaurant.getOwnerId());
        assertNotNull(restaurant.getImagePath());
    }
}
