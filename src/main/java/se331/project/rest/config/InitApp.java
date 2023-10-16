package se331.project.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Course;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.CourseRepository;
import se331.project.rest.repository.StudentRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    @Autowired

    final CourseRepository courseRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

    Advisor a1, a2, a3;
        a1 = advisorRepository.save(Advisor.builder()
            .name("Dr.Supanut")
            .surname("Manilmunggorn")
            .academic_position("SE Department Chief ")
            .department("SE")
            .build());
        a2 = advisorRepository.save(Advisor.builder()
                .name("Dr.Watcharit")
                .surname("Sangsom")
                .academic_position("SE Chief Assistant")
                .department("SE")
                .build());
        a3 = advisorRepository.save(Advisor.builder()
                .name("Dr.Kittipat")
                .surname("Talatubby")
                .academic_position("SE Professor")
                .department("SE")
                .build());


        
        Course c1,c2,c3;
        c1 = courseRepository.save(Course.builder()
                .name("Animation for Se")
                .courseid("953111")
                .description("For Create Animation")
                .build());
        c2 = courseRepository.save(Course.builder()
                .name("Component base")
                .courseid("953112")
                .description("This course is very hard")
                .build());
        c3 = courseRepository.save(Course.builder()
                .name("Math for Se")
                .courseid("953113")
                .description("This is mathematics for Se ")
                .build());

        Student tempStudent;
        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115005")
                .name("Kittipat")
                .surname("Tachamanokul")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a1);
        c1.getStudentHistory().add(tempStudent);
        c2.getStudentHistory().add(tempStudent);
        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115011")
                .name("Yanwarut")
                .surname("Suksawat")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a2);
        c1.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115012")
                .name("Yada")
                .surname("Lakhornjun")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a3);
        c2.getStudentHistory().add(tempStudent);
        c3.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115014")
                .name("Nichakamol")
                .surname("Sangsom")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a1);
        c1.getStudentHistory().add(tempStudent);
        c2.getStudentHistory().add(tempStudent);
        c3.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115041")
                .name("Wacharit")
                .surname("Srichai")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a3);
        c3.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115044")
                .name("Supanut")
                .surname("Maneeyot")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        tempStudent.setAdvisor(a2);
        c1.getStudentHistory().add(tempStudent);
        c2.getStudentHistory().add(tempStudent);
        c3.getStudentHistory().add(tempStudent);
    }


}
