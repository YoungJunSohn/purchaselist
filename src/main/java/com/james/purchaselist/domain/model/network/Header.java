package com.james.purchaselist.domain.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<V> {

    //api 통신시간
    private LocalDateTime transactionTime;

    //api 응답코드
    private String resultCode;

    //api 부가설명
    private String description;

    private V data;

    //OK
    public static <V> Header<V> ok() {
        return (Header<V>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //Data OK
    public static <V> Header<V> ok(V data) {
        return (Header<V>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data).build();
    }


    //ERROR
    public static <V> Header<V> error(String description) {
        return (Header<V>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description).build();
    }
}
