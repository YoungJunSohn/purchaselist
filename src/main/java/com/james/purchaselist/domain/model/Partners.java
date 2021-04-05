package com.james.purchaselist.domain.model;

import com.james.purchaselist.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"category", "itemsList"})
public class Partners extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    private String address;

    private String callCenter; //파트너사 고객센터번호

    private String partnerNumber; //파트너사 담당자 번호

    private String businessNumber; //사업자번호

    private String ceoName; //대표이름

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime unregisteredAt; //해지일자

    @ManyToOne
    private Categories category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Items> itemsList;

}
