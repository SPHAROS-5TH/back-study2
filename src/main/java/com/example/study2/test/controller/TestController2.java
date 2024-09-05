package com.example.study2.test.controller;

import com.example.study2.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class TestController2 {

    private final TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "hello2";
    }


}
