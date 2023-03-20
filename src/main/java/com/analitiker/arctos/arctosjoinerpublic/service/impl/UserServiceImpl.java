package com.analitiker.arctos.arctosjoinerpublic.service.impl;

import com.analitiker.arctos.arctosjoinerpublic.exceptions.UserSignUpValidationException;
import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.model.dto.SignupResponseDto;
import com.analitiker.arctos.arctosjoinerpublic.model.entity.Token;
import com.analitiker.arctos.arctosjoinerpublic.model.entity.UserEntity;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.TokenType;
import com.analitiker.arctos.arctosjoinerpublic.repository.UserRepository;
import com.analitiker.arctos.arctosjoinerpublic.service.DateService;
import com.analitiker.arctos.arctosjoinerpublic.service.TokenService;
import com.analitiker.arctos.arctosjoinerpublic.service.UserService;
import com.analitiker.arctos.arctosjoinerpublic.service.mapper.AssetsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final DateService dateService;
    private final AssetsMapper assetsMapper;
    //TODO
    //private final KafkaService kafkaService;

    @Override
    public Boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public SignupResponseDto preJoinUser(UserSignUpRequest userSignUpRequest) {
        if (userExists(userSignUpRequest.email()))
            throw new UserSignUpValidationException("User already exists"); //TODO take care of message config

        //generate activation token
        var token = tokenService.generatePINCode();
        var savedUser = userRepository.save(assetsMapper.userSignUpRequestToUserEntity(userSignUpRequest, token));
        //TODO send activation email
        // kafkaService.produce(savedUser.id, savedUser.token);
        return SignupResponseDto.builder()
                .token(savedUser.getToken().getValue())
                .build();
    }

    //TODO finish method
    @Override
    public Boolean activateUser(UUID uuid, String token) {
        var user = findUserById(uuid);
        Boolean validated = tokenService.validateToken(user.getToken(), token);
        return null;
    }

    @Override
    public String refreshUserToken(UUID uuid) {
        var user = findUserById(uuid);
        user.setToken(Token.builder()
                .tokenType(TokenType.ACTIVATION)
                .value(tokenService.generatePINCode())
                .activeTo(dateService.generateDatePlusOneDay())
                .build());
        userRepository.save(user);
        //TODO send activation email
        //kafkaService.produce(savedUser.id savedUser.token);
        return null;
    }

    private UserEntity findUserById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Unfortunately we couldn't find user"));
    }
}
