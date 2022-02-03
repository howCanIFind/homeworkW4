package com.sparta.homeworkw4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor  // DB 테이블 역할을 합니다.
@Entity // DB 테이블 역할을 합니다.
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
//    @Min(3) // 최소 입력
//    @Pattern(regexp="(^[a-zA-Z0-9]*$)", message = "아이디 형식에 맞지 않습니다.")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private Long kakaoId;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.kakaoId = null;
    }

    public User(String username, String password, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.kakaoId = kakaoId;
    }
}
