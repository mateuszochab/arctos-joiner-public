package com.analitiker.arctos.arctosjoinerpublic.model.entity;

import com.analitiker.arctos.arctosjoinerpublic.model.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Token {
    //TODO tune up entity class

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String value;
    private ZonedDateTime activeTo;
    private TokenType tokenType;
    @OneToOne(mappedBy = "token")
    private UserEntity user;
}
