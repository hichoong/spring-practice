package com.practice.spring.service;

import com.practice.spring.domain.DefineYn;
import com.practice.spring.domain.post.Post;
import com.practice.spring.domain.post.PostRepository;
import com.practice.spring.domain.user.User;
import com.practice.spring.domain.user.UserRepository;
import com.practice.spring.domain.user.UserRole;
import com.practice.spring.web.dto.SavePostRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    PostRepository postRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    PostService postService;

    @Test
    @DisplayName("게시글저장확인")
    void savePosts() {
        User user = User.createUser("충", UserRole.REALTOR, "user12");
        SavePostRequestDto savePostRequestDto = new SavePostRequestDto("안녕", "나야", user);
        Post post = Post.createPost(savePostRequestDto.getTitle(), savePostRequestDto.getContent(), user);
        lenient().when(postRepository.save(post)).thenReturn(post);

        Assertions.assertEquals(post.getTitle(), "안녕");
    }

    @Test
    void getPost() {
        User user = User.createUser("충", UserRole.REALTOR, "user12");
        SavePostRequestDto savePostRequestDto = new SavePostRequestDto("안녕", "나야", user);
        Post post = Post.createPost(savePostRequestDto.getTitle(), savePostRequestDto.getContent(), savePostRequestDto.getUser());
        lenient().when(postRepository.save(post)).thenReturn(post);
        lenient().when(postRepository.findById(post.getId())).thenReturn(Optional.of(post));
        Assertions.assertEquals(post.getTitle(), "안녕");
        Assertions.assertEquals(post.getUser().getNickname(), "충");
    }

    @Test
    void getPost2() {
        User user = User.createUser("충", UserRole.REALTOR, "user12");
        SavePostRequestDto savePostRequestDto = new SavePostRequestDto("안녕", "나야",user);
        Post post = Post.createPost(savePostRequestDto.getTitle(), savePostRequestDto.getContent(), user);
        lenient().when(postRepository.save(post)).thenReturn(post);
        lenient().when(postRepository.findById(post.getId())).thenReturn(Optional.of(post));
    }
}