package com.analitiker.arctos.arctosjoinerpublic.service;

import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.model.dto.SignupResponseDto;

import java.util.UUID;

public interface UserService {
    Boolean userExists(String username);

    SignupResponseDto preJoinUser(UserSignUpRequest userSignUpRequest);

    Boolean activateUser(UUID id, String token);

    String refreshUserToken(UUID id);
}
