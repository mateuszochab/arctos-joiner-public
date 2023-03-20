package com.analitiker.arctos.arctosjoinerpublic.controller;

import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;

    @GetMapping("/exist")
    Boolean checkIfUserExist(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.userExists(userSignUpRequest.email());
    }
}
