package com.example.restaurant.domain.order.menu.service.add;

import com.example.restaurant.domain.servicedto.ordermenu.OrderMenuDto;

public interface OrderMenuAddService {
    /**
     * userId 로 유저 검증
     * foodId 로 음식객체 가져옴
     * orderId 로 주문 리스트 가져옴
     * foodId 와 orderId 로 주문정보가 동일한게 있나 확인하여 있으면 업데이트 없으면 새로 생성
     * @param userId 유저의 고유번호
     * @param dto (foodId,orderId,count)
     */
    void add(Long userId, OrderMenuDto dto);
}
