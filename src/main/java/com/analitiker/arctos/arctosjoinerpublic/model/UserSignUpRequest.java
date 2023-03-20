package com.analitiker.arctos.arctosjoinerpublic.model;


import com.analitiker.arctos.arctosjoinerpublic.exceptions.UserSignUpValidationException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.beans.ConstructorProperties;

public record UserSignUpRequest(String password, String email, AccountVerification accountVerification) {
    @ConstructorProperties({"password", "email", "accountVerification"})
    public UserSignUpRequest {
        if (isEmailInvalid(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
            throw new UserSignUpValidationException("Please enter valid email");
        if (isPasswordInvalid(password))
            throw new UserSignUpValidationException("Password has to exist");
    }

    private boolean isEmailInvalid(String email, final String regex) {
        return email == null || !email.matches(regex);
    }

    private boolean isPasswordInvalid(String password) {
        return ObjectUtils.isEmpty(password)
                || StringUtils.containsWhitespace(password);
    }
}
