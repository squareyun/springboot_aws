/*
 프로젝트의 메인 클래스
 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 자동 설정. 이 위치부터 설정을 읽기 때문에 항상 프로젝트의 최상단에 위치해야함.
 */
package com.squareyun.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS를 실행 -> 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일로 실행 가능
        // 장점: 언제 어디서나 같은 환경에서 배포 가능
        SpringApplication.run(Application.class, args);
    }
}
