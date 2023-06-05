package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @Notnuill이 붙은 필드 생성자 추가
@Service // 빈에 등록

public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity()); //AddArticleRequest클래스에 저장된 값들 article db저장
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
