package se331.project.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.CourseDao;
import se331.project.rest.entity.Course;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    final CourseDao courseDao;
    @Override
    public List<Course> getAllCourse() {
        return courseDao.getCourse(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Course> getCourse(Integer page, Integer pageSize) {
        return courseDao.getCourse(PageRequest.of(page,pageSize));
    }
}
