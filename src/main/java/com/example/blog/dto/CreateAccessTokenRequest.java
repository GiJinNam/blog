package com.example.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CreateAccessTokenRequest {
    private String refreshToken;
}
