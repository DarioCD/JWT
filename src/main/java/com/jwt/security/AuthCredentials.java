package com.jwt.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//3

@Data
@Getter
@Setter
public class AuthCredentials {
    private String email;
    private String password;
}
