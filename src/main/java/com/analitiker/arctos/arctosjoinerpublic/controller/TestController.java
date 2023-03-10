package com.analitiker.arctos.arctosjoinerpublic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final DatabaseRepository databaseRepository;

    @GetMapping
    String testEndpoint() {
        return "App deployed in cluster";
    }

    @GetMapping("/add")
    String addUser() {
        databaseRepository.save(UserEntity.builder()
                .username("adam")
                .age(100)
                .build());
        return "done";
    }

    @GetMapping("/user")
    List<UserEntity> getUsers() {
        return databaseRepository.findAll();
    }
}
