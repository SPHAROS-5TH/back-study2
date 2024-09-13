package com.example.study2.test.controller;

import com.example.study2.test.dto.SearchProductRequestDto;
import com.example.study2.test.dto.SearchProductResponseDto;
import com.example.study2.test.entity.Product;
import com.example.study2.test.service.TestService;
import com.example.study2.test.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Slf4j
public class TestController {

    private final TestService testService;

    @GetMapping("/product/{productId}")
    public Product hello(@PathVariable Long productId) {

        Product result = testService.getProduct(productId);

        return result;
    }

    @PostMapping("/product")
    public ResponseCreateProductVo createProduct(@RequestBody RequestCreateProductVo requestCreateProductVo) {



        return testService.createProduct(RequestCreateProductDto.toDto(requestCreateProductVo)).toVo();
    }

    @GetMapping("/product")
    public List<ResponseGetProductVo> getProductList() {

        return testService.getProductList().stream().map(ResponseGetProductDto::toVo).toList();

    }

    @GetMapping("/search")
    public List<SearchProductResponseDto> searchProduct(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String color

    ) {

        log.info("keyword : {}", keyword);
        log.info("category : {}", category);
        log.info("size : {}", size);
        log.info("color : {}", color);

        return testService.searchProduct(SearchProductRequestDto.toDto(keyword, category, size, color));

    }





}
