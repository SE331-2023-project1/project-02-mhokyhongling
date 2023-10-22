package se331.project.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AdvisorDao;
import se331.project.rest.dao.CommentDao;
import se331.project.rest.dao.StudentDao;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    final CommentDao commentDao;


    @Override
    public List<Comment> getAllComment() {
        return null;
    }

    @Override
    public Integer getCommentSize() {
        return commentDao.getCommentSize();
    }
    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentDao.getComments(pageSize, page);
    }
    @Override
    public Comment getComment(Long id) {

        return commentDao.getComment(id);
    }
    @Override
    @Transactional
    public Comment save(Comment comment) {

        return commentDao.save(comment);
    }

    @Override
    public Page<Comment> getComments(String name, Pageable pageable) {

        return commentDao.getComments(name,pageable);
    }
}
