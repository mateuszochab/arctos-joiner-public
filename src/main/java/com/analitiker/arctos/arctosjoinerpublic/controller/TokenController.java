package com.analitiker.arctos.arctosjoinerpublic.controller;

import com.analitiker.arctos.arctosjoinerpublic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/token")
@RestController
@RequiredArgsConstructor
public class TokenController {
    private final UserService userService;

    @PostMapping("/activate/{id}/{token}")
    Boolean activateUser(@PathVariable String token, @PathVariable UUID id) {
        return userService.activateUser(id, token);
    }

    @PostMapping("/refresh/{id}")
    String refreshToken(@PathVariable UUID id) {
        return userService.refreshUserToken(id);
    }

}
