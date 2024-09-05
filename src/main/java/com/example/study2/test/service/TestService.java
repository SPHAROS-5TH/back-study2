package com.example.study2.test.service;

import com.example.study2.test.entity.Product;
import com.example.study2.test.repository.TestRepository;
import com.example.study2.test.vo.RequestCreateProductDto;
import com.example.study2.test.vo.ResponseCreateProductDto;
import com.example.study2.test.vo.ResponseGetProductDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public Product getProduct(Long productId) {

        // db에서 데이터를 조회
        Product result = testRepository.findById(productId).get();
        // 우리 비지니스 로직


        return result;
    }

    public ResponseCreateProductDto createProduct(RequestCreateProductDto requestProductDto) {

        return ResponseCreateProductDto.toDto(testRepository.save(requestProductDto.toEntity()));
    }

    public List<ResponseGetProductDto> getProductList() {

//        List<ResponseGetProductDto> list = new ArrayList<>();
//        for (Product asd : result) {
//            list.add(ResponseGetProductDto.toDto(asd));
//        }

        return testRepository.findAll().stream().map(ResponseGetProductDto::toDto).toList();

    }
}
