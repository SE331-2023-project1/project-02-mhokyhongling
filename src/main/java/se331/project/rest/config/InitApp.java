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
import java.util.List;

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
                .name("Dr.Pawisa")
                .surname("Manilmunggorn")
                .academic_position("SE Department Chief ")
                .department("SE")
                .images(List.of("https://wallpaperset.com/w/full/3/d/6/473897.jpg"))
                .build());
        a2 = advisorRepository.save(Advisor.builder()
                .name("Dr.Watcharit")
                .surname("Sangsom")
                .academic_position("SE Chief Assistant")
                .department("SE")
                .images(List.of("https://c4.wallpaperflare.com/wallpaper/906/685/91/x-men-x-men-patrick-stewart-patrick-stewart-wallpaper-preview.jpg"))
                .build());
        a3 = advisorRepository.save(Advisor.builder()
                .name("Dr.Kittipat")
                .surname("Talatubby")
                .academic_position("SE Professor")
                .department("SE")
                .images(List.of("https://www.pixel4k.com/wp-content/uploads/2021/07/the-professor-digital-painting-money-heist-4k_1627767087.jpg"))
                .build());

        Course c1,c2,c3;
        c1 = courseRepository.save(Course.builder()
                .name("Animation for Se")
                .courseid("953111")
                .description("For Create Animation")
                .images(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgG2ibNXhcNmqCmBeWn9Kjb4lEZJ8KBWgmg0fXRsQWwrzoGf9SJDtE8g9pi402JBj8KtA&usqp=CAU"))
                .build());
        c2 = courseRepository.save(Course.builder()
                .name("Component base")
                .courseid("953112")
                .description("This course is very hard")
                .images(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv7JLnX6AMmRGdISJ2jpIbHeuHdULU3sTHt1QZFLA3pBTwBbM86izMVRiokAddNnD1ais&usqp=CAU"))
                .build());
        c3 = courseRepository.save(Course.builder()
                .name("Math for Se")
                .courseid("953113")
                .description("This is mathematics for Se ")
                        .images(List.of("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgiuBW9e-_0iieqNCztpA0f9_GHFuuWPNrhfhemwHXcyAf-g7gQnN6O8JneoW7cNL5OIc&usqp=CAU"))
                .build());

        Student tempStudent;
        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115005")
                .name("Kittipat")
                .surname("Tachamanokul")
                .department("Software Engineer")
                .location("Chiang mai")
                .images(List.of("https://media.discordapp.net/attachments/642694730718642188/1164550789935669269/image.png?ex=65439f70&is=65312a70&hm=ab33254ff0feac8510f27a81e06d37877cc6b809a3a9b3a8a170fe11af8a321b&=&width=335&height=376"))
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
                .images(List.of("https://cdn.discordapp.com/attachments/642694730718642188/1164545614449745960/241730913_595553758140657_7491668169310401435_n.jpg?ex=65439a9e&is=6531259e&hm=1145bb405b88b0d43ce8d71ed47dc064b8f911f247009ff765df9828f4723a5c&"))
                .build());
        tempStudent.setAdvisor(a2);
        c1.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115012")
                .name("Yada")
                .surname("Lakhornjun")
                .department("Software Engineer")
                .location("Chiang mai")
                .images(List.of("https://media.discordapp.net/attachments/642694730718642188/1164547879705255986/80572261_2695040410589343_8228959049085878272_n.jpg?ex=65439cba&is=653127ba&hm=4ba19470df51c9e7c43c3c96438a15fcefbc6126d87f1e9c57b1ddb6186f6c49&=&width=663&height=662"))
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
                .images(List.of("https://media.discordapp.net/attachments/642694730718642188/1164549535775850588/1A05D42D-A695-47D0-958A-8DA13DEEAAAC.jpg?ex=65439e45&is=65312945&hm=dedae9d2307724ab7806e0adfabb30e077c72e582d98d54d5fe75a03dada31b6&=&width=573&height=662"))
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
                .images(List.of("https://media.discordapp.net/attachments/642694730718642188/1164549463168270376/image.png?ex=65439e34&is=65312934&hm=41590b4c445d9698c9b6c478b16266eafb6cb27b4014abb8ce23af6e78204905&=&width=403&height=438"))
                .build());
        tempStudent.setAdvisor(a3);
        c3.getStudentHistory().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .studentid("642115044")
                .name("Supanut")
                .surname("Maneeyot")
                .department("Software Engineer")
                .location("Chiang mai")
                .images(List.of("https://media.discordapp.net/attachments/642694730718642188/1164544825467609088/9b666c0e0f62fb21.jpg?ex=654399e2&is=653124e2&hm=51326fb791b4553aac8131a6cd327a8ba6ba62efb8bd217b2f9be4bf95db82e7&=&width=496&height=662"))
                .build());
        tempStudent.setAdvisor(a2);
        c1.getStudentHistory().add(tempStudent);
        c2.getStudentHistory().add(tempStudent);
        c3.getStudentHistory().add(tempStudent);
    }


}
