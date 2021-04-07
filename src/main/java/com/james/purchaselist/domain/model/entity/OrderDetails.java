package com.james.purchaselist.domain.model.entity;


import com.james.purchaselist.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user", "item", "orderGroup"})
public class OrderDetails extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; //주문 상태

    private LocalDateTime arrivalDate; //도착예정일자

    private Long quantity; //주문수량

    private BigDecimal totalPrice;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Items item;

    @ManyToOne
    private OrderGroups orderGroup;
}
