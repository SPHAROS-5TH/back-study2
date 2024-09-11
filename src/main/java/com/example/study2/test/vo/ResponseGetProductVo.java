package com.example.study2.test.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetProductVo {
    private Long id;
    private String productName;
//    private int price;
}
