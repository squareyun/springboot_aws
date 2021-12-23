package com.squareyun.study.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    // 롬복의 어노테이션 중 @Getter로 get 메소드가, @RequiredArgsConstructor로 생성자가 자동으로 생성되는 것 테스트
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        // Junit의 기본 assertThat이 아닌 'aseertj의 assertThat'을 사용한다.
        // 이것의 장점은 추가적인 라이브러리가 필요하지 않고, 자동완성이 좀 더 확실하게 지원되어 편하다는 것이다.
    }
}
