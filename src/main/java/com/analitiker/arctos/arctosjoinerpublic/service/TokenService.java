package com.analitiker.arctos.arctosjoinerpublic.service;

import com.analitiker.arctos.arctosjoinerpublic.model.entity.Token;

public interface TokenService {

    String generatePINCode();

    Boolean validateToken(Token usersToken, String incomingToken);
}
