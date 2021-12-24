/*
Entity 클래스와 유사한 형태임에도 Dto 클래스를 따로 생성했다.
Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이므로 절대로 그것을 Request/Response 클래스로 사용해서는 안된다.
View Layer와 DB Layer의 역할 분리를 철저하게 해줘야 한다.
 */

package com.squareyun.study.springboot.web.dto;

import com.squareyun.study.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
