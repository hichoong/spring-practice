package com.practice.spring.web.dto;

import com.practice.spring.domain.DefineYn;
import com.practice.spring.domain.user.UserRole;

public class SaveUserRequestDto {

    private String nickname;
    private UserRole accountType;
    private String accountId;
    private DefineYn defineYn;
}
