package com.squareyun.study.springboot.web;

import com.squareyun.study.springboot.service.posts.PostsService;
import com.squareyun.study.springboot.web.dto.PostsResponseDto;
import com.squareyun.study.springboot.web.dto.PostsSaveRequestDto;
import com.squareyun.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성. final이 없는 필드는 생성자에 포함되지 않음
@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // Put과 Post의 차이? 멱등성. 동일한 요청을 한 번 보내는 것과 여러 번 연속으로 보내는 것이 같은 효과를 지님
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
