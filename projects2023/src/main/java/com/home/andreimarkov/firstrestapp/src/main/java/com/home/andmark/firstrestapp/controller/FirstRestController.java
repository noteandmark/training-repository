package com.home.andmark.firstrestapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController //если класс помечен аннотацией @RestController, то каждый метод в классе по умолчанию возвращает данные и имеет аннотацию ResponseBody
@RequestMapping("/api")
public class FirstRestController {

//    @ResponseBody - говорит о том, что метод возвращает данные, а не отображение на браузер
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello world!";
    }
}
