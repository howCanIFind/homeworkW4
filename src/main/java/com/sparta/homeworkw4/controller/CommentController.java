package com.sparta.homeworkw4.controller;

import com.sparta.homeworkw4.dto.CommentRequestDto;
import com.sparta.homeworkw4.model.Comment;
import com.sparta.homeworkw4.repository.CommentRepository;
import com.sparta.homeworkw4.security.UserDetailsImpl;
import com.sparta.homeworkw4.service.CommentService;
import com.sparta.homeworkw4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/api/article")
    public String goArticle() {
        return "article";
    }


    @GetMapping("/api/comments")
    public List<Comment> getComment() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return commentRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    //comment 등록.
    @ResponseBody
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("controller");
        Long userId = userDetails.getUser().getId();
        System.out.println("controller");
        return commentService.createComment(requestDto, userId);
    }


    //comment 수정.


}
