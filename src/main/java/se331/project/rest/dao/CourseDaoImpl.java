package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Course;
import se331.project.rest.repository.CourseRepository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao{
    final CourseRepository courseRepository;

    @Override
    public Page<Course> getCourse(Pageable pageRequest) {
        return courseRepository.findAll(pageRequest);

    }
    @Override
    public Optional<Course> findById(Long id) {
        return  courseRepository.findById(id);
    }
}
