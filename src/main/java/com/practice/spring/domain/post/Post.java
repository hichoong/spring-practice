package com.practice.spring.domain.post;

import com.practice.spring.domain.BaseTimeEntity;
import com.practice.spring.domain.DefineYn;
import com.practice.spring.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User user;

    private DefineYn deleteYn;

    @Builder
    private Post(String title, String content, DefineYn deleteYn, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.deleteYn = deleteYn;
    }

    public static Post createPost(String title, String content, User user) {
        return new PostBuilder()
                .title(title)
                .content(content)
                .user(user)
                .deleteYn(DefineYn.N)
                .build();
    }
}
