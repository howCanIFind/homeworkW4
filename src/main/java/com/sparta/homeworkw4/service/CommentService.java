package com.sparta.homeworkw4.service;

import com.sparta.homeworkw4.dto.CommentRequestDto;
import com.sparta.homeworkw4.model.Comment;
import com.sparta.homeworkw4.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //  요청받은 DTO로 DB에 저장할 객체 만들기.
    public Comment createComment(CommentRequestDto requestDto, Long userId) {
        Comment comment = new Comment(requestDto, userId);

        commentRepository.save(comment);

        return comment;
    }
}
