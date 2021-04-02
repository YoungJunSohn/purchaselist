package com.james.purchaselist.domain.item;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Items extends BaseLogEntity<Items> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status; //상품상태

    private String name;

    private String title;

    @Column(columnDefinition = "text")
    private String content; //상품상세 설명

    @Column(columnDefinition = "decimal", precision = 12, scale = 4)
    private int price;

    private String brandName;

    private LocalDateTime registeredAt; //상품 등록일자

    private LocalDateTime unregisteredAt; //상품 해지일자
}
