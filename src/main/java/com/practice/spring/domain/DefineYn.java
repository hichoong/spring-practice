package com.practice.spring.domain;

import lombok.Getter;

@Getter
public enum DefineYn {

    Y("탈퇴", "삭제"), N("가입", "등록");

    private String value;
    private String value2;

    DefineYn(String value, String value2) {
        this.value = value;
        this.value2 = value2;
    }
}
