package com.example.blog.dto;

import com.example.blog.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {
    private final Long id;
    private final String title;
    private final String content;
    private LocalDateTime created_at;

    public ArticleViewResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.id = article.getId();
        this.created_at = article.getCreated_at();
    }

    public ArticleViewResponse() {
        this.id = this.getId();
        this.title = this.getTitle();
        this.content = this.getContent();
    }
}
