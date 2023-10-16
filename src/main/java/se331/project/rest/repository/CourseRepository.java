package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
