package com.james.purchaselist.domain.adminuser;

import com.james.purchaselist.domain.BaseLogEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class AdminUsers extends BaseLogEntity<AdminUsers> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String account;

    private String password;

    private String status;

    private LocalDateTime lastLoginAt;//마지막 로그인 일자

    private LocalDateTime passwordUpdatedAt;//비밀번호 갱신일자

    private int loginFailCount; //비밀번호 실패 이력

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime terminatedAt; //해지일자


}
