package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Student;

public interface StudentService {
    Integer getStudentSize();

    Page<Student> getStudents(Integer pageSize, Integer page);

    Student getStudent(Long id);
    Student save(Student student);

    Page<Student> getStudents(String name, Pageable pageable);
}
