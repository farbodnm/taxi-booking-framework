package com.taxi.user.dto;

import com.taxi.framework.user.dto.BaseUserSigninDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExtendedUserSigninDTO extends BaseUserSigninDTO {
    private String captcha;
}
