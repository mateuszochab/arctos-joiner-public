package com.analitiker.arctos.arctosjoinerpublic.service.mapper;

import com.analitiker.arctos.arctosjoinerpublic.model.entity.Token;
import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.model.entity.Contact;
import com.analitiker.arctos.arctosjoinerpublic.model.entity.UserEntity;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.ContactType;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.CountryMobilePhonePrefixType;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.VerificationType;
import com.analitiker.arctos.arctosjoinerpublic.service.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

import static com.analitiker.arctos.arctosjoinerpublic.model.enums.ContactOperationType.ADD;
import static com.analitiker.arctos.arctosjoinerpublic.model.enums.TokenType.ACTIVATION;
import static com.analitiker.arctos.arctosjoinerpublic.model.enums.VerificationType.PHONE;

@Component
@RequiredArgsConstructor
public class AssetsMapper {
    private final DateService dateService;

    public UserEntity userSignUpRequestToUserEntity(UserSignUpRequest usr, String token) {
        VerificationType verificationType = usr.accountVerification().getVerificationType();
        return UserEntity.builder()
                .password(usr.password())
                .email(usr.email())
                .activated(false)
                .token(Token.builder()
                        .value(token)
                        .activeTo(dateService.generateDatePlusOneDay())
                        .tokenType(ACTIVATION)
                        .build())
                .country(extractCountryFromMobilePhoneCountryPrefixType(
                        usr.accountVerification().getCountryMobilePhonePrefixType()))
                .contactList(Collections.singletonList(Contact.builder()
                        .contactType(verificationTypeToContactType(verificationType))
                        .operationType(ADD)
                        .contactValue(verificationType == PHONE
                                ? usr.accountVerification().getMobilePhoneNumber().toString()
                                : usr.accountVerification().getEmail())
                        .build()))
                .build();
    }

    public String extractCountryFromMobilePhoneCountryPrefixType(CountryMobilePhonePrefixType countryType) {
        //TODO think about dictionary etc.
        return switch (countryType) {
            case PL -> "Poland";
            case DK -> "Denmark";
        };
    }

    public ContactType verificationTypeToContactType(VerificationType verificationType) {
        return switch (verificationType) {
            case EMAIL -> ContactType.EMAIL;
            case PHONE -> ContactType.PHONE;
        };
    }
}
