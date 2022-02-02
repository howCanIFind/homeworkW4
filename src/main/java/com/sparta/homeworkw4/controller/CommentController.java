package com.sparta.homeworkw4.controller;

import com.sparta.homeworkw4.dto.CommentRequestDto;
import com.sparta.homeworkw4.model.Comment;
import com.sparta.homeworkw4.repository.CommentRepository;
import com.sparta.homeworkw4.security.UserDetailsImpl;
import com.sparta.homeworkw4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

//    @Autowired
//    public CommentController(UserService userService) {
//        this.userService = userService;
//    }

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
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();

        Comment comment = new Comment(requestDto, userId);
        return commentRepository.save(comment);
    }

    //comment 수정.


}
