package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.StudentRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDbImpl implements StudentDao{
    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {

        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(String studentid, Pageable page) {
        return studentRepository.findByStudentidContainingOrNameContainingOrSurnameContaining(studentid,studentid, studentid, page);


    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }


}
