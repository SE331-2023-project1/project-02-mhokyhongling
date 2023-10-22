package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Comment;

import java.util.Optional;

public interface CommentDao {
    Integer getCommentSize();
    Page<Comment> getComments(Integer pageSize, Integer page);
    Comment getComment(Long id);
    Comment save(Comment comment);
    Page<Comment> getComments(String name, Pageable page);
    Optional<Comment> findById(Long id);
}
