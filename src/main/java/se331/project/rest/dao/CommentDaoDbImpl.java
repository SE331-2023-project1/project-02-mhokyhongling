package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Comment;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.CommentRepository;
import se331.project.rest.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class CommentDaoDbImpl implements CommentDao{

    final CommentRepository commentRepository;
    @Override
    public Integer getCommentSize() {
        return Math.toIntExact(commentRepository.count());
    }

    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {

        return commentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getComments(String name, Pageable page) {
        return null;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }
    @Override
    public List<Comment> findByStudentId(Long id){
        return commentRepository.findCommentByStudent_Id(id);
    }

}