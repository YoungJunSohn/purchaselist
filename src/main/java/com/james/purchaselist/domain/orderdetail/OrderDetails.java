package com.james.purchaselist.domain.orderdetail;


import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderDetails extends BaseLogEntity<OrderDetails> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status; //주문 상태

    private LocalDateTime arrivalDate; //도착예정일자

    private int quantity; //주문수량

    @Column(columnDefinition = "decimal", precision = 12, scale = 4)
    private int totalPrice;

}
