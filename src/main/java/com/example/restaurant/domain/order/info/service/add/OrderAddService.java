package com.example.restaurant.domain.order.info.service.add;

public interface OrderAddService {
    /**
     * userId, ownerId, restaurantId 를 받아 주문 리스트 생성하고 검증
     * @param userId 유저의 고유번호
     * @param ownerId 가게주인의 고유번호
     * @param restaurantId 가게의 고유번호
     * @return orderId 주문의 고유번호를 반환
     */

    Long add(Long userId, Long ownerId, Long restaurantId);
}
