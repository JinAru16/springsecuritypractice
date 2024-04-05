package com.security.hellosecurity.auth.repository;

import com.security.hellosecurity.auth.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findUsersByUserId(String userId);
}
