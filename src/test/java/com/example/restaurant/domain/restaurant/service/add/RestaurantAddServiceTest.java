package com.example.restaurant.domain.restaurant.service.add;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RestaurantAddServiceTest {
    private final OwnerRepository ownerRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantAddService restaurantAddService;

    @Autowired
    RestaurantAddServiceTest(OwnerRepository ownerRepository, RestaurantRepository restaurantRepository, RestaurantAddService restaurantAddService) {
        this.ownerRepository = ownerRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantAddService = restaurantAddService;
    }

    @Test
    void 식당_추가_정상작동(){
        byte[] imageBytes = "test-image".getBytes();
        String imageName = "test-image.jpg";
        MockMultipartFile file = new MockMultipartFile("file", imageName, "image/jpeg", imageBytes);

        Owner owner = new Owner("owner","1234");
        ownerRepository.save(owner);
        RestaurantDto dto = new RestaurantDto("restaurant","123","1234");

        restaurantAddService.add(dto, owner.getId(),file);
        Optional<Restaurant> restaurant = restaurantRepository.findByOwnerId(owner.getId());
        assertEquals(dto.getName(),restaurant.get().getName());
        assertEquals(dto.getBusinessAddress(),restaurant.get().getBusinessAddress());
        assertEquals(dto.getCallNum(),restaurant.get().getCallNum());
        assertEquals(owner.getId(),restaurant.get().getOwnerId());
        assertNotNull(restaurant.get().getImagePath());
    }
}