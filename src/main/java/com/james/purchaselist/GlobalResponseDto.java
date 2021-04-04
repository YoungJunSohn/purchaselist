package com.james.purchaselist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponseDto<V> {

    private LocalDateTime transactionTime;

    private String resultCode;

    private String description;

    private V data;

    private Object pagination;

}
