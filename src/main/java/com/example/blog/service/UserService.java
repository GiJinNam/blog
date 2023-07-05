package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.dto.AddUserRequest;
import com.example.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserService {
    private final UserRepository userRepository;

//    public Long Save(AddUserRequest dto) {
//        return userRepository.save(User.builder()
//                .email(dto.getEmail())
//                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
//                .build()).getId();
//    }

    public Long Save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    //JWT 리프레쉬 토큰을 전달받아, 새로운 액세스 토큰 생성하는 토큰 서비스
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
    // 이메일을 입력받아 user 테이블에서 찾고 없으면 예외발생    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()->
                    new IllegalArgumentException("unexpected User")
                );
    }
}

