package com.analitiker.arctos.arctosjoinerpublic.model;

import com.analitiker.arctos.arctosjoinerpublic.exceptions.UserSignUpValidationException;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.CountryMobilePhonePrefixType;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.VerificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountVerification {
    private VerificationType verificationType;
    private Integer mobilePhoneNumber;
    private String email;
    private CountryMobilePhonePrefixType countryMobilePhonePrefixType;

    public AccountVerification(VerificationType verificationType, Integer mobilePhoneNumber,
                               String email,
                               CountryMobilePhonePrefixType countryMobilePhonePrefixType) {
        this.verificationType = verificationType;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
        this.countryMobilePhonePrefixType = countryMobilePhonePrefixType;
        if (this.isMobilePhoneNumberInvalid())
            throw new UserSignUpValidationException("Provide valid phone number");
    }

    private boolean isMobilePhoneNumberInvalid() {
        return mobilePhoneNumber == null || !mobilePhoneNumber.toString().matches("^[0-9]*$");
    }
}