package com.practice.spring.service;

import com.practice.spring.domain.post.Post;
import com.practice.spring.domain.post.PostRepository;
import com.practice.spring.domain.user.User;
import com.practice.spring.domain.user.UserRepository;
import com.practice.spring.web.dto.SavePostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public List<Post> getPosts() {
        return postRepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    public void savePost(SavePostRequestDto savePostRequestDto, Long id) {
        User findeUser = userRepository.findById(id).get();
        Post post = Post.createPost(savePostRequestDto.getTitle(), savePostRequestDto.getContent(), findeUser);
        postRepository.save(post);
    }
}
