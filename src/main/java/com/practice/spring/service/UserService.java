package com.practice.spring.service;

import com.practice.spring.domain.user.User;
import com.practice.spring.domain.user.UserRepository;
import com.practice.spring.web.dto.SaveUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(SaveUserRequestDto saveUserRequestDto) {

    }
}
