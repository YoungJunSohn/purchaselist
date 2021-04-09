package com.james.purchaselist.controller;

import com.james.purchaselist.domain.model.network.CrudInterface;
import com.james.purchaselist.domain.model.network.Header;
import com.james.purchaselist.domain.model.network.request.UserRequest;
import com.james.purchaselist.domain.model.network.response.UserResponse;
import com.james.purchaselist.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
public class UserController implements CrudInterface<UserRequest, UserResponse> {

    private final UserService userService;

    @Override
    @PostMapping("")
    public Header<UserResponse> create(@RequestBody Header<UserRequest> userRequest) {
        log.info("UserController : create /{}", userRequest);
        return userService.create(userRequest);
    }

    @Override
    @GetMapping("/{id}")
    public Header<UserResponse> read(@PathVariable Long id) {
        log.info("UserController : read /{}", id);
        return userService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserResponse> update(@RequestBody Header<UserRequest> userRequest) {
        log.info("UserController : update /{}", userRequest);
        return userService.update(userRequest);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header<UserResponse> delete(@PathVariable Long id) {
        log.info("UserController : delete /{}", id);
        return userService.delete(id);
    }
}
