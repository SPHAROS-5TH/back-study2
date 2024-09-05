package com.example.study2.test.vo;

import com.example.study2.test.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetProductDto {
    private Long id;
    private String name;
    private int price;

    public static ResponseGetProductDto toDto(Product product) {
        return ResponseGetProductDto.builder()
                .name(product.getName())
                .id(product.getId())
                .price(product.getPrice())
                .build();
    }

    public ResponseGetProductVo toVo() {
        return ResponseGetProductVo.builder()
                .id(id)
                .productName(name)
//                .price(price)
                .build();
    }
}
