package com.springboot.yongeun.first.web.dto;

import com.springboot.yongeun.first.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){ //entity의 필드 일부만 사용 -> 생성자로 entity 받아 필드에 값 넣음
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content= entity.getContent();
        this.author=entity.getAuthor();
    }

}
