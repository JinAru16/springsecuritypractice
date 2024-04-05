package com.security.hellosecurity.auth.api;

import com.security.hellosecurity.auth.domain.entity.Users;
import com.security.hellosecurity.auth.domain.request.UserCreate;
import com.security.hellosecurity.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Users signup(@RequestBody @Validated UserCreate userCreate){
        return userService.createUser(userCreate);
    }
}
