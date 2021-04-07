package com.james.purchaselist.domain.model.entity;

import com.james.purchaselist.domain.Auditable;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderDetailsList", "partner"})
public class Items extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; //상품상태

    private String name;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content; //상품상세 설명

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt; //상품 등록일자

    private LocalDateTime unregisteredAt; //상품 해지일자

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetails> orderDetailsList;

    @ManyToOne
    private Partners partner;
}
