package com.analitiker.arctos.arctosjoinerpublic.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignupResponseDto {
    private String token;
    private String id;
}
