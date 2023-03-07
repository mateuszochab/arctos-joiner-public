package com.analitiker.arctos.arctosjoinerpublic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    String testEndpoint(){
        return "App deployed in cluster";
    }
}
