package com.james.purchaselist.repository;


import com.james.purchaselist.PurchaseListApplicationTests;
import com.james.purchaselist.domain.model.entity.Partners;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PartnerRepositoryTest extends PurchaseListApplicationTests {

    @Autowired
    private PartnersRepository partnersRepository;

    @Test
    public void create() {
        String name = "파트너테스트1";
        String status = "파트너상태1";
        String address = "파트너주소1파트너주소1파트너주소1파트너주소1파트너주소1파트너주소1파트너주소1";
        String callCenter = "010-1234-5678";
        String businessNumber = "12345678944";
        String ceoName = "대표이름1";
        LocalDateTime registeredAt = LocalDateTime.now();

        Partners partner = new Partners();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);

        Partners newPartner = partnersRepository.save(partner);
        assertNotNull(newPartner);

    }

    public void read() {

    }
}
