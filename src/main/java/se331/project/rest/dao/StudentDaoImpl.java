package se331.project.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import se331.project.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class StudentDaoImpl implements  StudentDao{
    List<Student> studentList;

    @PostConstruct
public void init() {
        studentList =new ArrayList<>();
        studentList.add(Student.builder()
                .id(001L)
                .studentid("642115005")
                .name("Kittipat")
                .surname("Tachamanokul")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(002L)
                .studentid("642115011")
                .name("Yanwarut")
                .surname("Suksawat")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(003L)
                .studentid("642115012")
                .name("Yada")
                .surname("Lakhornjun")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(003L)
                .studentid("642115015")
                .name("Nichakamol")
                .surname("Sangsom")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(004L)
                .studentid("642115041")
                .name("Wacharit")
                .surname("Srichai")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(005L)
                .studentid("642115041")
                .name("Wacharit")
                .surname("Srichai")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        studentList.add(Student.builder()
                .id(006L)
                .studentid("642115044")
                .name("Supanut")
                .surname("Maneeyot")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
    }
    @Override
    public Integer getStudentSize() {
        return studentList.size();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? studentList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Student>(studentList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),studentList.size());
    }
    @Override
    public Student getStudent (Long id) {
        return studentList.stream().filter(event ->
                event.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public Student save(Student student) {
        student.setId(studentList.get(studentList.size()-1).getId()+1);
        studentList.add(student);
        return student;
    }
    @Override
    public Page<Student> getStudents(String title, Pageable page) {
        return null;
    }
}
