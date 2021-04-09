package com.james.purchaselist.controller;

import com.james.purchaselist.domain.model.network.request.UserRequest;
import com.james.purchaselist.domain.model.network.response.UserResponse;
import com.james.purchaselist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
public class UserController extends CrudController<UserRequest, UserResponse> {

    private final UserService userService;

    @PostConstruct
    public void init() {
        this.baseService = userService;
    }

}
