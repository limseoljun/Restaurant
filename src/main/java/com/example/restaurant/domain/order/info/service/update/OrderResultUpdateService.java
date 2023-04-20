package com.example.restaurant.domain.order.info.service.update;

public interface OrderResultUpdateService {
    /**
     * userId orderId 를 받아 둘다 가지는 객체 존재하면 가져와서 result 값 변경
     * @param userId 유저의 고유번호
     * @param orderId 주문의 고유번호
     * @param result 주문 상태 (결제,조리중,배달중 등)
     * @return 업데이트 되면 true 안되면 false
     */
    boolean update(Long userId, Long orderId, String result);
}
