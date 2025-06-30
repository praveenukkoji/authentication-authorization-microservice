package com.praveenukkoji.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String fullname;

    @Column(unique = true, nullable = false)
    @Email(message = "format of email is invalid")
    private String email;

    @Column(nullable = false)
    private String password;
}
