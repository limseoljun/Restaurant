package com.example.restaurant.domain.order.menu.service.update;

import java.util.List;

public interface OrderMenuListUpdateService {
    /**
     * orderInId 를 받아 주문의 고유 번호를 가지는 주문메뉴 리스트를 가져옴
     * 그 리스트 안에 리스트로 묶은 counts 를 받아 객체 의 count를 변경
     * @param counts 음식 수량 들의 리스트
     * @param orderInId 주문의 고유번호
     */
    void update(List<Integer> counts, Long orderInId);
}
