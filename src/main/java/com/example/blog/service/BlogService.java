package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.domain.User;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.dto.UpdateArticleRequest;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @Notnuill이 붙은 필드 생성자 추가
@Service // 빈에 등록

public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request,String userName) {
        return blogRepository.save(request.toEntity(userName)); //AddArticleRequest클래스에 저장된 값들 article db저장
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found + " + id));
    }

    public void delete(long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        authorizeArticleAuthor(article);
        blogRepository.delete(article);

    }

    @Transactional
    public Article update(long id , UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("not found + " + id));
        authorizeArticleAuthor(article);
        article.update(request.getTitle(),request.getContent());

        return article;
    }

    //게시글을 작성한 유저인지 확인 메소드
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!article.getAuthor().equals(userName)) {
            throw new IllegalStateException("not authorized");
        }
    }

}
