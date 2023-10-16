package se331.project.rest.service;

import org.springframework.data.domain.Page;
import se331.project.rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Page<Course> getCourse(Integer page, Integer pageSize);

}
