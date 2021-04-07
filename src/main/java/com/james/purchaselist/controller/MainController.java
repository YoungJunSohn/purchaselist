package com.james.purchaselist.controller;

import com.james.purchaselist.domain.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/header")
    public Header getHeader() {

        return Header.builder()
                .resultCode("OK")
                .description("OK").build();
    }
}
