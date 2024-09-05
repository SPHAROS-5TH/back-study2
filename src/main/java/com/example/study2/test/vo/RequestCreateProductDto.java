package com.example.study2.test.vo;

import com.example.study2.test.entity.Product;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateProductDto {
    private String name;
    private int price;

    public static RequestCreateProductDto toDto(RequestCreateProductVo vo) {
        return RequestCreateProductDto.builder()
                .name(vo.getName())
                .price(vo.getPrice())
                .build();
    }

    public Product toEntity() {
        return Product.builder()
                .price(price)
                .name(name)
                .build();
    }
}
