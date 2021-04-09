package com.james.purchaselist.domain.model.entity;

import com.james.purchaselist.domain.Auditable;
import com.james.purchaselist.domain.enumclass.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderGroupsList", "orderDetailsList"})
public class Users extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status; //회원상태

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt; //가입일자

    private LocalDateTime unregisteredAt; //해지일자

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroups> orderGroupsList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetails> orderDetailsList;

}
