package com.sparta.homeworkw4.repository;

import com.sparta.homeworkw4.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    List<Comment> findAllByUserId(Long userId);
}
