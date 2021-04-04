package com.james.purchaselist.domain.ordergroup;

import com.james.purchaselist.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderGroups extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; //주문 상태

    private String orderType; //일괄 또는 개별

    @Column(columnDefinition = "TEXT")
    private String revAddress; //배송지 주소

    private String revName; //수령인

    private String paymentType; //납부방법

    private BigDecimal totalPrice;

    private Long totalQuantity; //수량

    private LocalDateTime orderAt; //주문일자

    private LocalDateTime arrivalDate; //도착예정일자

}
