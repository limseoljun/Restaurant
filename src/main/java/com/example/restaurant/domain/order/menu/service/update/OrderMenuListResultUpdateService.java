package com.example.restaurant.domain.order.menu.service.update;

public interface OrderMenuListResultUpdateService {
    /**
     * orderInId를 받아 주문 번호를 가지는 주문메뉴의 리스트를 받아옴
     * 리스트들의 주문상태를 result 값을 받아 업데이트
     * @param orderInId 주문의 고유번호
     * @param result 주문상태
     */
    void update(Long orderInId, String result);
}
