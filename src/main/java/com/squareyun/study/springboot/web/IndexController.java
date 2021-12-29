package com.squareyun.study.springboot.web;

import com.squareyun.study.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성. final이 없는 필드는 생성자에 포함되지 않음
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc()); // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장. 결과를 posts로 index.mustache에 전달
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
