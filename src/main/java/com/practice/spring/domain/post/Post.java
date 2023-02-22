package com.practice.spring.domain.post;

import com.practice.spring.domain.BaseTimeEntity;
import com.practice.spring.domain.DefineYn;
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

    private DefineYn deleteYn;

    @Builder
    private Post(String title, String content, DefineYn deleteYn) {
        this.title = title;
        this.content = content;
        this.deleteYn = deleteYn;
    }

    public Post createPost(String title, String content) {
        return new PostBuilder()
                .title(title)
                .content(content)
                .deleteYn(DefineYn.N)
                .build();
    }
}
