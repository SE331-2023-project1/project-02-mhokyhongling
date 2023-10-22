package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();
    Integer getCommentSize();

    Page<Comment> getComments(Integer pageSize, Integer page);

    Comment getComment(Long id);
    Comment save(Comment comment);

    Page<Comment> getComments(String name, Pageable pageable);
}
