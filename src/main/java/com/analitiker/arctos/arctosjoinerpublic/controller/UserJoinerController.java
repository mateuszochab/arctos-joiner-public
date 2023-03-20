package com.analitiker.arctos.arctosjoinerpublic.controller;

import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.model.dto.SignupResponseDto;
import com.analitiker.arctos.arctosjoinerpublic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/signup")
@RestController
@RequiredArgsConstructor
public class UserJoinerController {

    private final UserService userService;

    @PutMapping()
    SignupResponseDto signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.preJoinUser(userSignUpRequest);

        //TODO provide id hashing mechanism + return hashed id with token
    }
}
