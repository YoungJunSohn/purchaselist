package com.james.purchaselist.domain.user;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Users extends BaseLogEntity<Users> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String account;

    private String password;

    private String status; //회원상태

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime unregisteredAt; //해지일자
    
}
