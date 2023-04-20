package com.example.restaurant.domain.order.menu.service.update;

public interface OrderMenuResultUpdateService {
    /**
     * userId 와 orderMenuId 를 가지는 주문메뉴를 가져와서 result 값을 받아 업데이트
     * @param userId 유저의 고유번호
     * @param orderMenuId 주문메뉴의 고유번호
     * @param result 주문상태
     * @return 업데이트 되면 true 안되면 false 반환
     */
    boolean update(Long userId, Long orderMenuId, String result);
}
