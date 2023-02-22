package com.practice.spring.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {

    REALTOR("공인중개사"), LESSOR("임대인"), LESSEE("임차인");

    private String value;

    UserRole(String value) {
        this.value = value;
    }
}
