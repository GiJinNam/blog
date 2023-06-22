package com.example.blog.service;

import com.example.blog.config.jwt.TokenProvider;
import com.example.blog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor

public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;
    // 전달받은 리프레쉬 토큰으로 토큰 유효성 검사하고 유효한 토큰이면 리프레쉬 토큰으로 사용자ID찾기.
    // 사용자 ID로 찾은후에 토큰제공자 generateToken 메소드 호출해 새로운 액세스 토큰 생성
    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalStateException("Unexpected User");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
