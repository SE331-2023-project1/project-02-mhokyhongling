package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;

import java.util.Optional;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
    Page<Student> getStudents(String name, Pageable page);
    Optional<Student> findById(Long id);

}
