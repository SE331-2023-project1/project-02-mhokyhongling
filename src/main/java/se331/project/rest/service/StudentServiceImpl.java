package se331.project.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AdvisorDao;
import se331.project.rest.dao.StudentDao;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;

    final AdvisorDao advisorDao;

    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }
    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }
    @Override
    @Transactional
    public Student save(Student student) {
//        Advisor advisor = advisorDao.findById(student.getAdvisor().getId()).orElse(null);
//        if (advisor != null) {
//            student.setAdvisor(advisor);
//            advisor.getOwnStudents().add(student);
//        }else {
//            return studentDao.save(student);
//        }
        return studentDao.save(student);
    }


    @Override
    public Page<Student> getStudents(String studentid, Pageable pageable) {
                return studentDao.getStudents(studentid,pageable);
            }

}
