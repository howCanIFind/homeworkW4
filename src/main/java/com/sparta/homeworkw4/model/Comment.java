package com.sparta.homeworkw4.model;

import com.sparta.homeworkw4.dto.CommentRequestDto;
import com.sparta.homeworkw4.dto.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long userId;

    public Comment(String contents, Long userId) {
        this.contents = contents;
        this.userId = userId;
    }

    public Comment(CommentRequestDto requestDto, Long userId) {
        this.contents = contents;
        this.userId = userId;
    }
}
