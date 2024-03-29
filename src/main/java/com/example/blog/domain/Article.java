package com.example.blog.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="author" , nullable = false)
    private String author;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateAt;

    @Builder
    public Article(String title, String content,String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

