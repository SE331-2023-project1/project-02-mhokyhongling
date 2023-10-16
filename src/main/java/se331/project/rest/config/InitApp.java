package se331.project.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.CourseRepository;
import se331.project.rest.repository.StudentRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
        Student s1, s2, s3, s4, s5,s6;
        s1 = studentRepository.save(Student.builder()
                .id(001L)
                .studentid("642115005")
                .name("Kittipat")
                .surname("Tachamanokul")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        s2 = studentRepository.save(Student.builder()
                .id(002L)
                .studentid("642115011")
                .name("Yanwarut")
                .surname("Suksawat")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        s3 = studentRepository.save(Student.builder()
                .id(003L)
                .studentid("642115012")
                .name("Yada")
                .surname("Lakhornjun")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        s4 = studentRepository.save(Student.builder()
                .id(004L)
                .studentid("642115041")
                .name("Wacharit")
                .surname("Srichai")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        s5 = studentRepository.save(Student.builder()
                .id(005L)
                .studentid("642115041")
                .name("Wacharit")
                .surname("Srichai")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
        s6 = studentRepository.save(Student.builder()
                .id(006L)
                .studentid("642115044")
                .name("Supanut")
                .surname("Maneeyot")
                .department("Software Engineer")
                .location("Chiang mai")
                .build());
    }
//        Organizer org1, org2, org3;
//        org1 = organizerRepository.save(Organizer.builder()
//                .name("CAMT").build());
//        org2 = organizerRepository.save(Organizer.builder()
//                .name("CMU").build());
//        org3 = organizerRepository.save(Organizer.builder()
//                .name("ChiangMai").build());
//        Event tempEvent;
//        tempEvent = eventRepository.save(Event.builder()
//                .category("Academic")
//                .title("Midterm Exam")
//                .description("A time for taking the exam")
//                .location("CAMT Building")
//                .date("3rd Sept")
//                .time("3.00-4.00 pm.")
//                .petAllowed(false)
//                .build());
//        tempEvent.setOrganizer(org1);
//        org1.getOwnEvents().add(tempEvent);
//        p1.getEventHistory().add(tempEvent);
//        p2.getEventHistory().add(tempEvent);
//        p3.getEventHistory().add(tempEvent);
//        tempEvent = eventRepository.save(Event.builder()
//                .category("Academic")
//                .title("Commencement Day")
//                .description("A time for taking the exam")
//                .location("CMU Convention hall")
//                .date("21th Jan")
//                .time("8.00am-4.00 pm.")
//                .petAllowed(false)
//                .build());
//        tempEvent.setOrganizer(org1);
//        org1.getOwnEvents().add(tempEvent);
//        p1.getEventHistory().add(tempEvent);
//        p2.getEventHistory().add(tempEvent);
//        p3.getEventHistory().add(tempEvent);
//        tempEvent = eventRepository.save(Event.builder()
//                .category("Cultural")
//                .title("Loy Krathong")
//                .description("A time for Krathong")
//                .location("Ping River")
//                .date("21th Nov")
//                .time("8.00-10.00 pm.")
//                .petAllowed(false)
//                .build());
//        tempEvent.setOrganizer(org2);
//        org2.getOwnEvents().add(tempEvent);
//        p1.getEventHistory().add(tempEvent);
//        p2.getEventHistory().add(tempEvent);
//        p4.getEventHistory().add(tempEvent);
//        tempEvent = eventRepository.save(Event.builder()
//                .category("Cultural")
//                .title("Songkran")
//                .description("Let's Play Water")
//                .location("Chiang Mai Moat")
//                .date("13th April")
//                .time("10.00-6.00 pm.")
//                .petAllowed(false)
//                .build());
//        tempEvent.setOrganizer(org3);
//        org3.getOwnEvents().add(tempEvent);
//        p3.getEventHistory().add(tempEvent);
//        p4.getEventHistory().add(tempEvent);
//        p5.getEventHistory().add(tempEvent);
//        addUser();
//        org1.setUser(user1);
//        user1.setOrganizer(org1);
//        org2.setUser(user2);
//        user2.setOrganizer(org2);
//        org3.setUser(user3);
//        user3.setOrganizer(org3);
//
//
//    }
}
