package com.james.purchaselist.domain.orderdetail;


import com.james.purchaselist.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; //주문 상태

    private LocalDateTime arrivalDate; //도착예정일자

    private Long quantity; //주문수량

    private BigDecimal totalPrice;

}
