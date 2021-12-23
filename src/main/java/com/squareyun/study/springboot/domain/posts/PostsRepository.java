/*
인터페이스로 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
반드시 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
 */

package com.squareyun.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
