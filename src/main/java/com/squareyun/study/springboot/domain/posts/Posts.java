/*
Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.

도메인 모델: 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해하고 공유할 수 있도록 단순화 한 것
@Entity가 사용된 영역 역시 도메인 모델이나, 무조건 DB의 테이블과 관계가 있어야하는 것은 아님
*/

package com.squareyun.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {

    @Id // 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙. IDENTITY 옵션은 auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 선언하지 않아도 모든 필드는 칼럼으로 사용되지만, 추가 옵션을 주기 위해 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
