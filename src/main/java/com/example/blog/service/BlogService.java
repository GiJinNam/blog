package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.domain.User;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.dto.UpdateArticleRequest;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
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

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found + " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id , UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("not found + " + id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }

}
