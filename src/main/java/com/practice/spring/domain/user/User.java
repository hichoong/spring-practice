package com.practice.spring.domain.user;

import com.practice.spring.domain.BaseTimeEntity;
import com.practice.spring.domain.DefineYn;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole accountType;

    @Column(nullable = false)
    private String accountId;

    private DefineYn quit;

    @Builder
    private User(String nickname, UserRole accountType, String accountId, DefineYn quit) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.accountId = accountId;
        this.quit = quit;
    }

    public static User createUser(String nickname, UserRole accountType, String accountId, DefineYn quit) {
        return new UserBuilder()
                .nickname(nickname)
                .accountType(accountType)
                .accountId(accountId)
                .quit(DefineYn.N)
                .build();
    }


}
