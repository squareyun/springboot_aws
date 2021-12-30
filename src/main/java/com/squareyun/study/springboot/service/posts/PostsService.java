/*
Service Layer는 트랜잭션, 도메인 기능 간의 순서를 보장
 */

package com.squareyun.study.springboot.service.posts;

import com.squareyun.study.springboot.domain.posts.Posts;
import com.squareyun.study.springboot.domain.posts.PostsRepository;
import com.squareyun.study.springboot.web.dto.PostsListResponseDto;
import com.squareyun.study.springboot.web.dto.PostsResponseDto;
import com.squareyun.study.springboot.web.dto.PostsSaveRequestDto;
import com.squareyun.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없다. 이것은 JPA의 영속성 컨텍스트 때문이다.
        // 더티 체킹으로 트랜잭션이 끝나는 시점에 변화가 있는 모든 엔티티 객체를 디비에 자동 반영해준다. (https://jojoldu.tistory.com/415)

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 옵션: 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        postsRepository.delete(posts); // JpaRepository에서 이미 delete 메소드를 지원하고 있음. deleteById 메소드를 이용해도 됨
    }
}
