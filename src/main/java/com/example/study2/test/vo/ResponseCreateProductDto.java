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
public class ResponseCreateProductDto {
    private Long id;
    private String name;
    private int price;

    public static ResponseCreateProductDto toDto(Product product) {
        return ResponseCreateProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public ResponseCreateProductVo toVo() {
        return ResponseCreateProductVo.builder()
                .id(id)
                .name(name)
//                .price(price)
                .build();
    }
}
