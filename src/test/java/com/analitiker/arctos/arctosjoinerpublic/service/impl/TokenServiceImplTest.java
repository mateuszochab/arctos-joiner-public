package com.analitiker.arctos.arctosjoinerpublic.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class TokenServiceImplTest {
    @InjectMocks
    private TokenServiceImpl tokenService;

    @Test
    void generatePINCode() {
        var a = tokenService.generatePINCode();

        assertThat(a.length() == 6);
        assertThat(Integer.getInteger(a));
    }
}