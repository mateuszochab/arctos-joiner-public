package com.analitiker.arctos.arctosjoinerpublic.model.entity;

import com.analitiker.arctos.arctosjoinerpublic.model.enums.ContactOperationType;
import com.analitiker.arctos.arctosjoinerpublic.model.enums.ContactType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Contact {
    //TODO tune up entity class

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private ContactType contactType;
    private String contactValue;
    private ContactOperationType operationType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
