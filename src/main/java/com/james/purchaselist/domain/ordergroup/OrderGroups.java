package com.james.purchaselist.domain.ordergroup;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderGroups extends BaseLogEntity<OrderGroups> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status; //주문 상태

    private String orderType; //일괄 또는 개별

    @Column(columnDefinition = "text")
    private String revAddress; //배송지 주소

    private String revName; //수령인

    private String paymentType; //납부방법

    @Column(columnDefinition = "decimal", precision = 12, scale = 4)
    private int totalPrice;
    
    private int totalQuantity; //수량
    
    private LocalDateTime orderAt; //주문일자
    
    private LocalDateTime arrivalDate; //도착예정일자
    
}
