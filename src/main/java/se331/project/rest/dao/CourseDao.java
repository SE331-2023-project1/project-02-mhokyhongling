package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Course;

import java.util.Optional;

public interface CourseDao {
    Page<Course> getCourse(Pageable pageRequest);
    Optional<Course> findById(Long id);
}
