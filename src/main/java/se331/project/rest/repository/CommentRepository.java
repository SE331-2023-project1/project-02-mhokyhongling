package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

