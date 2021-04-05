package com.james.purchaselist.domain.model;

import com.james.purchaselist.domain.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdminUsers extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private LocalDateTime lastLoginAt;//마지막 로그인 일자

    private LocalDateTime passwordUpdatedAt;//비밀번호 갱신일자

    private Long loginFailCount; //비밀번호 실패 이력

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime terminatedAt; //해지일자


}
