package com.sparta.homeworkw4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class CommentRequestDto {
    //  본문 내용.
    private String contents;

    private String userId;
}
