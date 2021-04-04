package com.james.purchaselist.controller;

import com.james.purchaselist.GlobalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {

//    private final UserService userService;

    @PostMapping("/{id}")
    public GlobalResponseDto create(@RequestParam Long id){
//        return userService.create(id);
        return null;
    }
}
