package com.example.blog.service;

import com.example.blog.domain.RefreshToken;
import com.example.blog.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    // 전달받은 리프레쉬 토큰으로 리프레쉬 토큰 객체를 검색해서 전달하는 메소드
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected Token"));
    }
}
