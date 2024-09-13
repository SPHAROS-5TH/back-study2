package com.example.study2.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductRequestDto {
    private String keyword;
    private String category;
    private String size;
    private String color;

    public static SearchProductRequestDto toDto (
        String keyword,
        String category,
        String size,
        String color
    ) {
        return SearchProductRequestDto.builder()
            .keyword(keyword)
            .category(category)
            .size(size)
            .color(color)
            .build();
    }
}
