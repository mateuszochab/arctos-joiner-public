package com.analitiker.arctos.arctosjoinerpublic.controller;

import com.analitiker.arctos.arctosjoinerpublic.model.AccountVerification;
import com.analitiker.arctos.arctosjoinerpublic.model.UserSignUpRequest;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.CountryMobilePhonePrefixType;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.VerificationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserJoinerController.class)
class UserJoinerControllerTest {

    @Autowired
    private MockMvc mvc;


//    @Test
//    public void signUpNewUser() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .put("/signup")
//                        .content(asJsonString(new UserSignUpRequest("pass", "matt@pass@email.com",
//                                new AccountVerification(VerificationType.EMAIL, 123456789, "email@email", CountryMobilePhonePrefixType.PL))))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}