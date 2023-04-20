package com.example.restaurant.domain.order.info.service.add;

import com.example.restaurant.domain.servicedto.order.OrderDto;

public interface OrderMoreAddService {
    /**
     * userId 를 받아 주문리스트의 객체를 찾아서 있으 주문메뉴를 추가
     * @param userId 유저의 고유번호
     * @param dto 음식의 고유번호,식당의 고유번호,음식의 수량 등
     * @return orderId 주문의 고유번호를 반환
     */
    Long more(Long userId, OrderDto dto);
}
