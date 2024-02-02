package com.taxi.framework.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class BaseUserSignupDTO {
    private String username;
    private String password;
    private Date dateOfBirth;
}
