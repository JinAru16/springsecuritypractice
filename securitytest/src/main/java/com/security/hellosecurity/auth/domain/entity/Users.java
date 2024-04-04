package com.security.hellosecurity.auth.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId;
    private String password;

    @Column(unique = true)
    private String email;
    private String authority;

    @Builder
    public Users(String userId, String password, String email, String authority) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }
}
