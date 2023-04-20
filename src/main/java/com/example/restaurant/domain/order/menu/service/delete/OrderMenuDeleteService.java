package com.example.restaurant.domain.order.menu.service.delete;

public interface OrderMenuDeleteService {
    /**
     * userId 와 orderMenuId 를 받아 두번호를 가진 객체가 존재하면 실행
     * @param userId 유저의 고유번호
     * @param orderMenuId 주문메뉴의 고유번호
     * @return 삭제되면 true 안되면 false
     */
    boolean delete(Long userId, Long orderMenuId);
}
