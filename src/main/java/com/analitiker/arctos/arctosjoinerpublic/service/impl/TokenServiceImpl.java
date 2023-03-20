package com.analitiker.arctos.arctosjoinerpublic.service.impl;

import com.analitiker.arctos.arctosjoinerpublic.model.entity.Token;
import com.analitiker.arctos.arctosjoinerpublic.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Random;

@Service
public class TokenServiceImpl implements TokenService {
    //TODO extract to some properties so it could be dynamically changed with external config
    private static final String PIN_CODE_FORMAT = "%06d";
    private static final Integer PIN_CODE_BOUND = 999999;

    @Override
    public String generatePINCode() {
        return String.format(PIN_CODE_FORMAT, new Random().nextInt(PIN_CODE_BOUND));
    }

    @Override
    public Boolean validateToken(Token usersToken, String incomingToken) {
        return validateTokenValue(usersToken.getValue(), incomingToken)
                && validateTokenDate(usersToken.getActiveTo());
    }

    //TODO finish method
    private boolean validateTokenDate(ZonedDateTime activeTo) {
        if (!activeTo.toLocalDateTime().isAfter(LocalDateTime.now())) {
            //kafka logs

            //throw exception and create annotation for logging
            //TODO custom exception message + storage for messages

            throw new RuntimeException("");
        } else {
            return true;
        }
    }

    //TODO finish method
    private boolean validateTokenValue(String tokenValue, String incomingToken) {
        if (!tokenValue.equals(incomingToken)) {
            //kafka logs

            //throw exception and create annotation for logging
            //TODO custom exception message + storage for messages
            throw new RuntimeException("");
        } else {
            return true;
        }
    }
}
