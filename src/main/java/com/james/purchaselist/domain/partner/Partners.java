package com.james.purchaselist.domain.partner;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Partners extends BaseLogEntity<Partners> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String status;

    private String address;

    private String callCenter; //파트너사 고객센터번호

    private String partnerNumber; //파트너사 담당자 번호

    private String businessNumber; //사업자번호

    private String ceoName; //대표이름

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime unregisteredAt; //해지일자

}
