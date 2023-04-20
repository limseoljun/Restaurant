package com.example.restaurant.domain.order.info.service.delete;

public interface OrderDeleteService {
    /**
     * userId 와 orderId 를 받아 두 번호를 가진 객체가 존재하면 삭제
     * @param userId 유저의 고유번호
     * @param orderId 주문의 고유번호
     * @return 삭제되면 true 안되면 false
     */
    boolean delete(Long userId, Long orderId);
}
