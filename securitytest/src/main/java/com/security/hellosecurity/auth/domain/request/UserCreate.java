package com.security.hellosecurity.auth.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreate {

    @NotEmpty(message = "사용자 ID는 필수입니다.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;

}
