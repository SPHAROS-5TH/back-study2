package com.example.study2.test.service;

import com.example.study2.common.exception.CustomException;
import com.example.study2.common.exception.ErrorCode;
import com.example.study2.test.entity.Product;
import com.example.study2.test.repository.TestRepository;
import com.example.study2.test.vo.RequestCreateProductDto;
import com.example.study2.test.vo.ResponseCreateProductDto;
import com.example.study2.test.vo.ResponseGetProductDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public Product getProduct(Long productId) {

        Product result = testRepository.findById(productId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );


        return result;
    }

    @Transactional
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
