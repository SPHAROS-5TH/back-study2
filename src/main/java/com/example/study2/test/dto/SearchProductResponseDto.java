package com.example.study2.test.dto;

import com.example.study2.test.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductResponseDto {
    private Long id;
    private String name;

    public static SearchProductResponseDto toDto(Product product) {
        return SearchProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
