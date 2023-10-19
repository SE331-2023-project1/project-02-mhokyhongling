package se331.project.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();

    Page<Student> findByStudentid(String studentid, Pageable pageRequest);
    Page<Student> findByStudentidContaining(String studentid, Pageable pageRequest);
    Page<Student> findByStudentidContainingOrNameContaining(String studentid, String name, Pageable pageRequest);
    Page<Student> findByStudentidContainingOrNameContainingOrSurnameContaining(String studentid, String name, String surname, Pageable pageRequest);

}
