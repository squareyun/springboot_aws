/*
Service Layer는 트랜잭션, 도메인 기능 간의 순서를 보장
 */

package com.squareyun.study.springboot.service.posts;

import com.squareyun.study.springboot.domain.posts.PostsRepository;
import com.squareyun.study.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    
    // Autowired가 없네? 이유는 생성자로 의존성 주입을 받기 때문
    // 롬복을 사용하게 되면 해당 클래스의 의존성 관계가 변경되어도 코드 변경이 필요없음
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
